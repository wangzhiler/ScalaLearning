package com.wzl.chapter11_functionalProgramming

object HigherOrderFun {


  def main(args: Array[String]): Unit = {

    def test(f:Double => Double, f2:Double => Int, n1:Double)={
      f(f2(n1))
    }

    def sum(d:Double):Double={
      d+d
    }

    def mod(d:Double):Int={
      d.toInt%2
    }

    val res=test(sum,mod,5.0)
    println(res)


    // 返回匿名函数
    def minusxy(x:Int)={
      (y:Int) => x-y
    }

    // f1就是 (y:Int) => 3-y
    val f1=minusxy(3)
    println(f1(5))

    val result2=minusxy(3)(5)
    println(result2)

  }
}
