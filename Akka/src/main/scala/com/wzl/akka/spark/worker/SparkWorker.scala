package com.wzl.akka.spark.worker

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import com.wzl.akka.spark.common.{HeartBeat, RegisterWorkInfo, SendHeartBeat}

import scala.concurrent.duration._

class SparkWorker(masterHost:String, masterPort:Int) extends Actor {
  // masterProxy是Master的代理/引用ref
  var masterProxy: ActorSelection = _
  val id = java.util.UUID.randomUUID().toString

  override def preStart(): Unit = {
    // 初始化masterProxy
    masterProxy = context
      .actorSelection(s"akka.tcp://SparkMaster@${masterHost}:${masterPort}/user/SparkMaster-01")
  }

  override def receive: Receive = {
    case "start" => {
      println("worker启动了")
      // 发送一个注册信息
      masterProxy ! RegisterWorkInfo(id, 16, 16 * 1024)
    }
    case RegisterWorkInfo => {
      println("workerId:"+id+" 注册成功！")

      // 当注册成功，就定义一个定时器 每隔一定时间SendHeartBeat给自己
      import context.dispatcher
      context.system.scheduler.schedule(
        // 0 millis: 立即触发。 3000millis 每隔3s。self:发给自己
        0 millis, 3000 millis, self, SendHeartBeat)
    }
    case SendHeartBeat => {
      println("worker="+id+" 给master发送信条")
      masterProxy ! HeartBeat(id)
    }
  }
}

object SparkWorker {
  def main(args: Array[String]): Unit = {

    val workerHost = "127.0.0.1"
    val workerPort = 10001
    val masterHost = "127.0.0.1"
    val masterPort = 10005

    val config = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname=$workerHost
         |akka.remote.netty.tcp.port=$workerPort
     """.stripMargin
    )

    val sparkWorkerSystem = ActorSystem("SparkWorker", config)

    // 创建SparkWorker的引用/代理
    val sparkWorkerRef = sparkWorkerSystem.actorOf(Props(
      new SparkWorker(masterHost, masterPort)), "SparkWorker-01")
    sparkWorkerRef ! "start"
  }
}