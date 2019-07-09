package com.wzl.chapter11_functionalProgramming

object Closure {

  def main(args: Array[String]): Unit = {

    def minusxy(x:Int)= (y:Int)=> x-y // 该函数与x构成闭包
    // f就是闭包
    val f=minusxy(20)
    println(f(1))
    println(f(2))


    /*

    函数makeSuffix(suffix:String) 可以接受一个文件后缀 返回一个闭包
    调用闭包，可以传入文件名，如果改文件名没有执行的后缀，返回文件名.jpg，否则返回原文件名
    String.endsWith(xx

     */

    // 使用并测试
    val f2 =makeSuffix(".jpg") // 传统的方法需要每次传入suffix
    println(f2("dog.jpg"))
    println(f2("cat.jpg"))
    println(f2("cat"))
    println(f2("ca"))


  }


  def makeSuffix(suffix:String)={
    // 返回一个匿名函数，会使用到suffix
    (filename:String) => {
      if(filename.endsWith(suffix)){
        filename
      }else{
        filename+suffix
      }
    }
  }

}


