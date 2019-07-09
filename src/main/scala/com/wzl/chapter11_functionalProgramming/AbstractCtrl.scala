package com.wzl.chapter11_functionalProgramming

object AbstractCtrl {

  // 控制抽象
  // 将一段代码 作为参数传递给高阶函数 在高阶函数内部执行这段断码

  // 1. 参数是函数
  // 2. 函数参数没有输入值也没有返回值

  def main(args: Array[String]): Unit = {

    def myRunInThread(f1: ()=>Unit)={
      new Thread{
        override def run(): Unit = {
          f1()
        }
      }.start()
    }

    myRunInThread{
      () => {
        println("干活咯 5s完成")
        Thread.sleep(5000)
        println("结束")
      }
    }


    def myRunInThread2(f1: =>Unit)={
      new Thread{
        override def run(): Unit = {
          f1
        }
      }.start()
    }

    // 对于没有输入也没有返回值的函数 可以简写成如下形式
    myRunInThread2 {
      println("干活咯 5s完成")
      Thread.sleep(5000)
      println("结束")
    }



    var x=10
    until(x>0){
      x -= 1
      println("x="+x)
    }


  }

  // 使用抽象控制 写出until函数
  def until(condition: => Boolean)(block: => Unit):Unit ={
    // 类似while循环 递归
    if(condition) {
      block
      until(condition)(block)
    }
  }
}




















