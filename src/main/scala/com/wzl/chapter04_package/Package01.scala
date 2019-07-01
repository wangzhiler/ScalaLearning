package com.wzl{


  class User{
    def sayHello(): Unit ={
      import com.wzl.scala1.Monster
      val monster=new Monster()
    }
  }

  package scala1{

    import scala.beans.BeanProperty

    class User{
      // 1. 相对路径
      @BeanProperty var age:Int=_

      // 2. 和1一样
      @scala.beans.BeanProperty var age2:Int=_

      // 3. 绝对路径
      @_root_.scala.beans.BeanProperty var age3:Int=_
    }
    class Monster{}
  }

  package scala2{
    class Person1{
      val name="Nick"
      def play(message:String): Unit ={
        println(this.name+" "+message)
      }
    }

    object Test100{
      def main(args: Array[String]): Unit = {
        println("ok")
        val user=new User

        // 使用包对象的方法
        println(name)
        met()
      }
    }
  }

  package test1{
    class Person5{}
  }

  // 在包中直接写方法/变量会报错 =》使用包对象
  // package object scala1表示创建一个包对象scala1，是com.wzl.scala1这个包对应的包对象
  // 每个包都可以有包对象，名字要一样
  package object scala2{
    val name="king"

    def met(): Unit ={
      println("helloooo")
    }
  }
}