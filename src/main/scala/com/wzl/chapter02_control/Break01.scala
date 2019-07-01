package com.wzl.chapter02_control

import util.control.Breaks._

object Break01 {

  def main(args: Array[String]): Unit = {

    var n=1

    // breakable()
    // 说明
    // 1) breakable()是一个高阶函数：可以接受函数的函数
    // 2)
    // def breakable(op: => Unit) {
    //    try {
    //      op
    //    } catch {
    //      case ex: BreakControl =>
    //        if (ex ne breakException) throw ex
    //    }
    //  }
    //  (1) op:=>Unit 表示接受的参数是个没有输入，也没有返回值的函数
    //  (2) 可以简单理解可以接受一段代码块
    //  (3) 对break()抛出的异常进行捕获
    //  (4) 当我们传入代码块，scala会将()改成{}

    breakable(
      while(n<20) {
        n+=1
        println("n="+n)
        if(n==18){
          // 中断while
          // 说明
          // 1) scala中使用函数式的break()中断循环
          // 2) def break():Nothing={throw breakException}
          break()
        }
      }
    )

    println("ok~~")
  }
}
