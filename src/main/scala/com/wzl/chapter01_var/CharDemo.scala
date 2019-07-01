package com.wzl.chapter01_var

object CharDemo {
  def main(args: Array[String]): Unit = {
    var char1: Char = 97
    println("char1: " + char1)  // a

    // char 可以 -> int
    var char2: Char='a'
    var num=10+char2
    println("num: "+num)

    // int 不可以 -> char
//    var c2:Char='a'+1
  }
}
