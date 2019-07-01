package com.wzl.chapter05_oo

import scala.beans.BeanProperty

object Property01 {

  def main(args: Array[String]): Unit = {
    val worker=new Worker("smith")

    val worker2=new Worker2("jackk")
    println(worker2.inName)

    val worker3=new Worker3("ppp")
    println(worker3.inName)
    worker3.inName="oiuytre"
    println(worker3.inName)

    var car=new Car
    car.name="abc"
    println(car.name)
    car.setName("aaa")
    println(car.getName)
  }
}

// 1. inName是一个局部变量
class Worker(inName:String){
  var name=inName
}

// 2. inName是Worker2的一个private的只读属性
class Worker2(val inName:String){
  var name=inName
}

// 3. inName是Worker3的一个private的可读写属性
class Worker3(var inName:String){
  var name=inName
}

// 使用BeanProperty 自动生成getXxx和 setXxx
class Car{
  @BeanProperty var name:String=null
}