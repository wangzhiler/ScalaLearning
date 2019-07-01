package com.wzl.chapter01_var

object UnitNullNothingDemo {

  def main(args: Array[String]): Unit = {
    val res=sayHello()
    println("res="+res)

    // Null类只有一个实例对象，null，等价于Java中的null引用。
    // null可以赋值给任意引用类型(AnyRef)，但不能赋值给值类型(AnyVal)
    val dog:Dog=null
//    val char1:char=null
  }

  // Unit等价于void，只有一个实例值()
  def sayHello(): Unit ={

  }
}
