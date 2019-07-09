package com.wzl.chapter11_functionalProgramming

object Curry {


  def main(args: Array[String]): Unit = {

    def mul(x:Int, y:Int)=x*y
    println(mul(10,10))

    def mulCurry(x:Int)=(y:Int) => x*y
    println(mulCurry(10)(9))

    def mulCurry2(x:Int)(y:Int) = x*y
    println(mulCurry2(10)(8))


    def eq1(s1:String)(s2:String)={
      s1.toLowerCase==s2.toLowerCase()
    }

    def eq2(s1:String, s2:String)={
      s1.equals(s2)
    }

    // 隐式类
    implicit class TestEq(s:String){
      def checkEq(ss:String)(f: (String,String)=> Boolean):Boolean={
        f(s.toLowerCase, ss.toLowerCase)
      }
    }

    val str1="hello"
    println(str1.checkEq("HellO")(eq2))

    println(str1.checkEq("HelLo")(_.equals(_)))

  }
}
