package com.wzl.chapter11_functionalProgramming

object ParameterInfer {

  def main(args: Array[String]): Unit = {


    val list=List(1,2,3,4)
    println(list.map((x:Int)=> x+1))
    println(list.map(x=> x+1))
    println(list.map(_ + 1))

    println(list.reduce(_+_))
  }
}
