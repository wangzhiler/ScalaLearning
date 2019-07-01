package com.wzl.chapter06_ooAdvance

object Self {

  // 为了解决特质的循环以来问题，限制混入该类型的类的类型
}

// 相当于  trait logger extends Exception
trait Logger{
  // 明确告诉编译器，我就是exception 如果没有这句话 不能用getMessage
  this:Exception =>
  def log(): Unit ={
    println(getMessage)
  }
}

//class Console extends Logger{}  // 这个是错的 因为Console没继承Exception
class Console extends Exception with Logger{} //可以