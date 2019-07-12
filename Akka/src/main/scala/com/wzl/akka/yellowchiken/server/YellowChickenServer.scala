package com.wzl.akka.yellowchiken.server

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import com.wzl.akka.yellowchiken.common.{ClientMessage, ServerMessage}

class YellowChickenServer extends Actor{
  override def receive: Receive = {
    case "start" => println("start Server开始工作了")
    // 如果接收到ClientMessage
    case ClientMessage(mes) => {
      // 使用 match --case 匹配
      mes match {
        case "学费" => sender() ! ServerMessage("120RMB")
        case "地址" => sender() ! ServerMessage("abc road")
        case "技术" => sender() ! ServerMessage("java")
        case _ => sender() ! ServerMessage("啥？")
      }
    }
  }
}

// 主程序-入口

object YellowChickenServer extends App{

  // 传统方法 无法传递ip和端口


  val host="127.0.0.1"
  val port=9999
  // 创建config对象，指定协议类型，监听的ip和端口
  val config=ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$host
       |akka.remote.netty.tcp.port=$port
     """.stripMargin
  )


  // 创建ActorSystem
  // url: 同一资源定位
  val serverActorSystem = ActorSystem("Server", config)
  // 创建YellowChickenServer 的actor和ActorRef
  private val yellowChickenServerRef: ActorRef = serverActorSystem
    .actorOf(Props[YellowChickenServer], "YellowChickenServer")

  // 启动
  yellowChickenServerRef ! "start"

}
