package com.wzl.chapter05_oo

object Abstract01 {

  def main(args: Array[String]): Unit = {
    val animal=new Animal2 {
      override def sayHi(): Unit = {
        println("say hi")
      }
    }
    animal.sayHi()
  }
}

// 抽象类
abstract class Animal{
  var name:String // 抽象的字段
  var age:Int //抽象的字段
  var color:String="black" // 普通属性
  def cry() // 抽象方法
}

abstract class Animal2{
  def sayHi(): Unit ={
    println("xxx")
  }
}
