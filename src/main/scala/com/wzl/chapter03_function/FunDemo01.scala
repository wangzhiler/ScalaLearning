package com.wzl.chapter03_function

object FunDemo01 {

  def main(args: Array[String]): Unit = {
    println("res="+getRes(1,2,')'))

    def sayOk(): Unit ={ // private final sayOk$1()
      println("main sayOK")

      def sayOk(): Unit ={ // private final sayOk$2()
        println("sayok in sayok")
      }
    }

    def vals(p1:String="v1", p2:String): Unit ={
      println(p1+p2)
    }
//    vals("v2")
    vals(p2 = "222")


  }

  def sayOk(): Unit ={ // 成员
    println("object sayok")
  }


  // 定义函数/方法
  def getRes(n1: Int, n2: Int, oper: Char)= {
    if (oper == '+') {
      n1 + n2
    }else if (oper == '-') {
      n1 - n2
    }else{
      null
    }
  }

  // exercise1 斐波那契数列
  def fbn(n:Int): Int= {
    if (n == 1 || n == 2) {
      1
    } else{
      fbn(n-1)+fbn(n-2)
    }
  }

  // exercise2 猴吃桃：猴第一天吃了一半+1，之后每天都吃其中一半，第十天只剩1个
  // day10  1
  // day9   (day10[1]+1)*2
  // day8   (day9[4]+1)*2
  //
  def peach(day: Int):Int={
    if(day==10) {
      1
    }else{
      (peach(day+1)+1)*2
    }
  }

  // 支持可变参数
  // 1~n个数求和
  def sum2(n1:Int, args:Int*):Int={
    var sum=n1
    for(item <- args) {
      sum+=item
    }
    sum
  }

  // X^n =x*x^(n-1)
  // X^0 =1
  // X^n =1/x^(-n)
  def mi(x:Double, n:Int):Double={
    if(n==0) 1
    else if(n>0)
      x*mi(x,n-1)
    else
      1/mi(x,-n)
  }
}
