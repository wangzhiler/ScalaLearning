package com.wzl.chapter05_oo

object Override01 {

  def main(args: Array[String]): Unit = {
    val emp=new Emp1
  }
}

class Person001{
  var name:String="tom"
  def printName(): Unit ={
    println("Person printName()"+name)
  }
  def sayHi(): Unit ={
  }
}

class Emp1 extends Person001{
  override def printName(): Unit ={
    println("Emp printName()"+name)
    super.printName()
    sayHi()
  }
}
