package com.wzl.chapter03_function

object Exception01 {

  def main(args: Array[String]): Unit = {

//    val res=test()
//    println(res.toString)

    try{
//      test()
      f11()
    }catch{
      case ex: Exception => println("捕获到异常"+ex.getMessage)
    }finally{

    }

    try{
      val r= 10/0
    }catch{
      case ex: ArithmeticException => println("捕获了除数为0的异常")
      case ex: Exception => println("捕获了异常")
    }finally{
      println("无论如何都要执行")
    }
  }

  def test():Nothing={
    throw new Exception("异常出现")
  }

  @throws(classOf[NumberFormatException])
  def f11()={
    "abc".toInt
  }
}
