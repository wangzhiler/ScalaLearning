package com.wzl.chapter01_var

import scala.io.StdIn

object Input {

  def main(args: Array[String]): Unit = {

    val name= StdIn.readLine()

    Cat.sayHi()
    Cat.sayHello()
  }
}

object Cat extends AAA{
  def sayHi(): Unit ={
    println("catttt")
  }
}

trait AAA{ // trait 等价于Java中的 Interface + abstract class
  def sayHello(){
    println("AAA say hello")
  }
}
