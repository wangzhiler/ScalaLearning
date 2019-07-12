package com.wzl.akka.yellowchiken.client

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import com.wzl.akka.yellowchiken.common.{ClientMessage, ServerMessage}

import scala.io.StdIn

class CustomerActor(serverHost:String, serverPort:Int) extends Actor{

  // 定义一个YellowChickenServerRef
  var serverActorRef : ActorSelection=_

  // 在Actor中有一个PreStart方法
  override def preStart(): Unit = {
    println("------prestart")
    serverActorRef=context.
      actorSelection(s"akka.tcp://Server@${serverHost}:${serverPort}/user/YellowChickenServer")
    println("serverActorRef="+serverActorRef)
  }

  override def receive: Receive = {
    case "start" => println("start,客户端运行")
    case mes:String => {
      // 发给服务器
      serverActorRef ! ClientMessage(mes)
    }
    case ServerMessage(mes) => {
      println(s"接收到Server的回复：${mes}")
    }
  }
}

object CustomerActor extends  App{

  val (clientHost, clientPort, serverHost, serverPort)=
    ("127.0.0.1", 9990, "127.0.0.1", 9999)
  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$clientHost
       |akka.remote.netty.tcp.port=$clientPort
     """.stripMargin
  )

  // 创建ActorSystem
  val clientActorSystem=ActorSystem("client", config)

  // 创建CustomerActor的实例和引用
  private val customerActorRef: ActorRef = clientActorSystem.actorOf(Props(
    new CustomerActor(serverHost, serverPort)), "CustomerActor")

  // 启动customerRef
  customerActorRef ! "start"

  // 客户端可以发送消息给服务器
  while(true){
    println("请输入要咨询的问题")
    val mes=StdIn.readLine()
    customerActorRef ! mes
  }

}
