package com.wzl.chapter08_collection

object OperatorOverload {

  def main(args: Array[String]): Unit = {
    val cat=new Cat
    cat+10
    println(cat.age)
  }
}

class Cat{
  var age=0
  def +(n:Int): Unit ={
    this.age+=n
  }
}
