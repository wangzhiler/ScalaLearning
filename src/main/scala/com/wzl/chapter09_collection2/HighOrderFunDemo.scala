package com.wzl.chapter09_collection2

object HighOrderFunDemo {

  def main(args: Array[String]): Unit = {
    // 使用高阶函数
    val res=test(sum _,3.5)
    val res2=test(sum,3.5)
    println(res)
    test2(sayOk)

    // scala中，可以把一个函数直接赋给一个变量,但是不执行该函数
    val f1=myPrint _
    f1() // ()=>Unit

  }

  def myPrint(): Unit ={
    println("hello world")
  }

  // 高阶函数 Demo1
  // 1. test为高阶函数
  // 2. f:Double=>Double 表示一个函数，接受Double 返回Double
  // 3. n1:Double 普通参数
  // 4. f(n1) 在test中 执行传入的函数
  def test(f:Double=>Double, n1:Double)={
    f(n1)
  }

  def sum(d:Double):Double={
    d+d
  }

  // 高阶函数 Demo2
  def test2(f:()=>Unit)={
    f()
  }
  def sayOk()={
    println("sayokkkkk")
  }

}
