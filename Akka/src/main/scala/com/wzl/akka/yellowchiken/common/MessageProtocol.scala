package com.wzl.akka.yellowchiken.common

// 使用样例类来构建协议
// 客户端给服务器协议 （序列化对象）
case class ClientMessage(mes:String)

// Server->Client
case class ServerMessage(mes:String)