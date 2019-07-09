package com.wzl.chapter11_functionalProgramming

object FunParameter {

  def main(args: Array[String]): Unit = {

    def plus(x:Int)=3+x

    val result1=Array(1,2,3,4).map(plus(_))
    println(result1.mkString(","))

    // scala中 函数也有类型，plus就是<function1>
    println(plus _)

  }
}
