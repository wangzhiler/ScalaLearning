package com.wzl.chapter01_var

object TypeDemo01 {

  def main(args: Array[String]): Unit = {
    var num1: Int=10
    // 一切都是对象
    // Int 是一个类
    // scala中如果一个方法没有形参，可以省略()
    println(num1.toDouble+"\t"+num1.toString)

    var isPass=true
    println(isPass.toString)

    sayHi
    sayHi()
  }

  def sayHi(): Unit ={
    println("say hi")
  }

}
