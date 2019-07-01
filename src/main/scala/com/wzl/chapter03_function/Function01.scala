package com.wzl.chapter03_function

object Function01 {

  def main(args: Array[String]): Unit = {
    val fun1=(x:Int, y:Int)=>x+y
    val fun2=(_:Int)+(_:Int)
    val fun3:(Int,Int) => Int =(_+_)

    println(fun1(2,2))
    println(fun2(2,2))
    println(fun3(2,2))
  }
}
