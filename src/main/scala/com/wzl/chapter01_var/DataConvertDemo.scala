package com.wzl.chapter01_var

object DataConvertDemo {

  def main(args: Array[String]): Unit = {
    // 强转符号只针对于最近的操作符有效
    val num1:Int=10*3.5.toInt + 6*1.5.toInt  //36
    val num2:Int=(10*3.5+6*1.5).toInt //44
  }
}
