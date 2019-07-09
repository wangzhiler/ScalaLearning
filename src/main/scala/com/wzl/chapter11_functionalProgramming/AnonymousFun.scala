package com.wzl.chapter11_functionalProgramming

object AnonymousFun {


  def main(args: Array[String]): Unit = {

    // 匿名函数
    // 1. 不用def 函数名
    // 2. 不用写返回类型 类型推到
    // 3. =>
    val triple= (x: Double) => 3*x
    println(triple(3))

    val f1=(n1:Int, n2: Int) => {
      println("匿名函数被调用")
      n1+n2
    }
    println("f1:"+f1)
    println(f1(10,30))
  }
}
