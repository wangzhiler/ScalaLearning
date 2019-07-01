package com.wzl.chapter02_control

object IfElse {

  def main(args: Array[String]): Unit = {
    // Scala中任意表达式有返回值，内容为代码块的最后一行
    val res=if(3<1) {
      9+10
    }else{
      "okkkk"
    }

    // 代替Java中的三元运算符
    val result=if(1<2) 1 else 0

    println(res)
  }
}
