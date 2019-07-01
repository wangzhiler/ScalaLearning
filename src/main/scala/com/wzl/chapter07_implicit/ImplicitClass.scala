package com.wzl.chapter07_implicit

object ImplicitClass {

  // 隐式类特点
  // 1. 构造参数只能有一个
  // 2. 必须定义在类/伴生对象/包对象里 不能是top-level objects
  // 3. 不能是case class
  // 4. 作用域内不能有与之相同名称的标识

  def main(args: Array[String]): Unit = {

    // db1是隐式类,当我们在该隐式类的作用域范围内，创建MySQL1实例
    // 该隐式类就会生效
    implicit class DB1(val m:MySQL1){
      def addSuffix():String={
        m+"scala"
      }
    }

    val mySQL=new MySQL1
    mySQL.sayOk()
    mySQL.addSuffix() // DB1$1(mySQL).addSuffix()
  }
}

class MySQL1{
  def sayOk(): Unit ={
    println("sayOk")
  }
}