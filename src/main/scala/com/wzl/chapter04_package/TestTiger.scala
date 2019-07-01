package com.wzl.chapter04_package

object TestTiger {

  def main(args: Array[String]): Unit = {
    // p1.tiger
    val tiger1=new com.wzl.chapter04_package.p1.Tiger

    // p2.tiger
    val tiger2=new com.wzl.chapter04_package.p2.Tiger

    println(tiger1+" "+tiger2)
  }
}
