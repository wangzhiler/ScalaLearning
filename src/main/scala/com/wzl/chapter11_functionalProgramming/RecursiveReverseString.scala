package com.wzl.chapter11_functionalProgramming

object RecursiveReverseString {

  def main(args: Array[String]): Unit = {
    val str="Hello World"
    println(reverse(str))

    println(factorial(10))
  }

  // 使用递归完成字符串翻转
  def reverse(xs:String):String={
    if(xs.length==1)
      xs
    else
      reverse(xs.tail)+xs.head
  }

  // 求出阶乘
  def factorial(n:Int):Int={
    if(n==0) 1 else n*factorial(n-1)
  }
}
