package com.wzl.akka.actor

import akka.actor.Actor

class BActor extends Actor{
  override def receive: Receive = {
    case "bbb" => {
      println("BActor() hiiiii")
      Thread.sleep(1000)

      // 通过sender() 可以获取到发送消息的actorRef
      sender() ! "self"
    }
  }
}
