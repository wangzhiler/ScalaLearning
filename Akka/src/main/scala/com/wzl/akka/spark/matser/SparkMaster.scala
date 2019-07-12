package com.wzl.akka.spark.matser

import akka.actor.{Actor, ActorSystem, Props}
import com.wzl.akka.spark.common._
import com.typesafe.config.ConfigFactory
import scala.concurrent.duration._


import scala.collection.mutable

class SparkMaster extends Actor {

  // 定义HashMap 管理Workers
  val workers = mutable.Map[String, WorkerInfo]()

  override def receive: Receive = {

    case "start" => {
      println("SparkMaster 启动了")
      // 触发心跳包
      self ! StartTimeOutWorker
    }
    case RegisterWorkInfo(id, cpu, ram) => {
      // 接收到Worker的注册信息
      // 装入HashMap
      if (!workers.contains(id)) {
        // 创建WorkerInfo对象
        val workerInfo = new WorkerInfo(id, cpu, ram)
        // 加入到workers
        workers += ((id, workerInfo))
        println("服务器workers=" + workers)
        // 回复一个消息，说注册成功
        sender() ! RegisterWorkInfo
      }

    }
    case HeartBeat(id) => {
      // 更新对应worker的心跳时间
      // 1. 取出workerInfo
      val workerInfo = workers(id)
      workerInfo.lastHeartBeat = System.currentTimeMillis()
      println("master更新了 " + id + " 心跳时间" + workerInfo.lastHeartBeat)
    }
    case StartTimeOutWorker => {
      println("开始了定时检测worker心跳的任务")
      import context.dispatcher
      context.system.scheduler.schedule(
        // 0 millis: 立即触发。 3000millis 每隔3s。self:发给自己
        0 millis, 9000 millis, self, RemoveTimeOutWorker)
    }
    // 检测哪些worker心跳超时(now-lasterHearBeat)>6s，并从map中删除
    case RemoveTimeOutWorker => {
      // 首先将所有workers的所有WorkerInfo
      val workerInfos = workers.values
      val nowTime = System.currentTimeMillis()
      // 先把超时的所有workerInfo删除
      workerInfos
        .filter(workerInfo => (nowTime - workerInfo.lastHeartBeat) > 6000)
        .foreach(workerInfo => workers.remove(workerInfo.id))
      println("当前有" + workers.size + "个worker存活")
    }
  }
}

object SparkMaster {
  def main(args: Array[String]): Unit = {
    // 先创建ActorSystem

    // akka.tcp://SparkMaster@127.0.0.1:10005
    val host = "127.0.0.1"
    val port = 10005
    // 创建config对象，指定协议类型，监听的ip和端口
    val config = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname=$host
         |akka.remote.netty.tcp.port=$port
     """.stripMargin
    )

    val sparkMasterSystem = ActorSystem("SparkMaster", config)
    // 创建SparkMaster -actor
    val sparkMasterRef = sparkMasterSystem
      .actorOf(Props[SparkMaster], "SparkMaster-01")

    sparkMasterRef ! "start"

  }
}