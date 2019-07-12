package com.wzl.akka.actor

import akka.actor.{ActorRef, ActorSystem, Props}

object ActorGame extends App {

    // 创建ActorSystem
    val actorFactory = ActorSystem("actorFactory")
    // 创建BActor引用
    val bActorRef:ActorRef = actorFactory.actorOf(Props[BActor], "bActor")
    // 创建AActor的引用
    val aActorRef = actorFactory.actorOf(Props(new AActor(bActorRef)), "aActor")

    // aActor出招
    aActorRef ! "start"
}
