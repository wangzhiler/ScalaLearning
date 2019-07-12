package com.wzl.akka.actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

// 1. 继承Actor之后 就是一个Actor
class SayHelloActor extends Actor{

  // 1. receive 会被该Actor的MailBox(实现了Runnable接口)调用
  // 2. 当该Actor的MailBox接收到消息，会调用receive
  // 3. type Receive = PartialFunction[Any,Unit]
  override def receive: Receive = {
    case "hello" => println("收到hello，回应hello too")
    case "ok" => println("收到ok，回应ok too")
    case "exit" => {
      println("接收到exit指令，退出系统")
      context.stop(self) // 停止actorRef
      context.system.terminate() //退出actorSystem
    }
    case _ => println("匹配不到")
  }
}


object SayHelloActorDemo{

  // 1. 先创建一个ActorSystem，专门用于创建Actor
  private val actorFactory = ActorSystem("actorFactory")
  // 2. 创建一个Actor的同时，返回Actor的ActorRef
  //  1) Props[SayHelloActor] 创建了一个SayHelloActor实例，使用反射
  //  2) "sayHelloActor"给actor取名
  //  3) sayHelloActorRef: ActorRef 就是 Props[SayHelloActor]的ActorRef
  private val sayHelloActorRef: ActorRef = actorFactory
    .actorOf(Props[SayHelloActor], "sayHelloActor")

  def main(args: Array[String]): Unit = {
    // 给 SayHelloActor 发消息(邮箱)
    sayHelloActorRef ! "hello"
    sayHelloActorRef ! "ok"
    sayHelloActorRef ! "ok~"

    // 退出ActorSystem
    sayHelloActorRef ! "exit"
  }

}