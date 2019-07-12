package com.wzl.akka.actor

import akka.actor.{Actor, ActorRef}

class AActor(actorRef: ActorRef) extends Actor{

  val bActorRef:ActorRef = actorRef


  override def receive: Receive = {
    case "start" => {
      println("AActor start")
      self ! "self" // 发给自己
    }
    case "self" => {
      // 给BActor发出消息，需要持有BActor Ref
      // ref只能在构建的时候传入
      println("AActor() hello")
      Thread.sleep(1000)

      bActorRef ! "bbb" // 发给bActorRef
    }

  }
}
