package com.wzl.akka.spark.common


// Worker 注册信息
case class RegisterWorkInfo(id:String, cpu:Int, ram:Int)

// WorkerInfo 保存到master的hashmap
class WorkerInfo(val id:String, val cpu:Int, val ram:Int){
  var lastHeartBeat :Long= System.currentTimeMillis()
}

// 当Worker注册成功，服务器返回RegisterWorkInfo对象
case object RegisterWorkInfo


// worker每隔一定时间由定时器发给自己的一个消息
case object SendHeartBeat

// worker每隔一定时间由定时器触发，而向master发现的协议消息
case class HeartBeat(id:String)


// master 给自己发送了一个触发检查超时的worker信息
case object StartTimeOutWorker

// master 给自己法消息 检测Worker 对于信心跳超时
case object RemoveTimeOutWorker


