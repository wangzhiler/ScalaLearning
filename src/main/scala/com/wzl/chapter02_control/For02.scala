package com.wzl.chapter02_control


object For02 {

  def main(args: Array[String]): Unit = {

    // for i=10 i>0 i--
    for(i<-0 to 10 reverse) {
      print(i+" ")
    }

    println("")

    // List集合
    val list=List(1,2,3)
    print(list.reverse)
    println("")
    print((1 to 10).reverse) //Range(10,9,...)

    // 高阶
    val res1=(0 to 10).reverse
    res1.foreach(myShow)

    // 计算字符串中所有字母的Unicode代码的乘积
    var res3:Long=1
    var res4:Long=1
    var res5:Long=1
    for(i<-"Hello") {
      res3 *= i.toLong
    }
    println("res3:"+res3)

    "Hello".foreach(myCount)
    println("res4:"+res4)

    def myCount(char: Char): Unit ={
      res4 *= char.toLong
    }

    "Hello".foreach(res5 *= _.toLong)
    println("res5:"+res5)

    // 改成递归

  }

  def countDown(n:Int): Unit ={
    // 高阶函数特性
    (0 to n).reverse.foreach(println)

  }

  def myShow(n:Int): Unit ={
    print(n+" xx ")
  }

  def product(s:String): Long ={
    if(s.length==1)
      return s.charAt(0).toLong
    else
      // s.take(1): 返回s的第一个字符
      // s.drop(1): 返回s除去第一个字符的所有字符
      s.take(1).charAt(0).toLong * product(s.drop(1))
  }
}
