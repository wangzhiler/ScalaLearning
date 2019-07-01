package com.wzl.chapter07_implicit

object ImplicitVar {

  // 优先级： 传值》implicit》默认值
  def main(args: Array[String]): Unit = {

    implicit val str1:String="Jack"
    def hello(implicit name:String): Unit ={ // 底层 hello$1(str1)
      println(name+"hello")

      def hello(): Unit ={ // hello$2
        println("xxx")
      }
    }

    // 当同时有默认值和implicit值 implicit的优先级更高
    // 如果没有匹配到implicit 就显示默认值
    def hello2(implicit content:String="abc"): Unit ={
      println("hello2:"+content)
    }

    hello

    hello("jol")
  }

  def hello(): Unit ={
    println("aaa")
  }
}


