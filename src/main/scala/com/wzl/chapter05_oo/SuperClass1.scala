package com.wzl.chapter05_oo

object SuperClass1 {
  def main(args: Array[String]): Unit = {

    // 1. 父类构造器 Person...
    // 2. Emp... Emp的主构造器
    val emp=new Emp5()
    println("===")

    // 1. 父类构造器 Person...
    // 2. Emp... Emp的主构造器
    // 3. Emp 辅助构造器
    val emp2=new Emp5("mary")

    println("===")


    // 1. Person...
    // 2. 默认的名字
    // 3. emp...
    // 4. Emp辅助构造器
    val emp3 = new Emp6("smith")

    val emp4=new Emp6("poo",10)
  }
}

class Person5{
  var name="zhangsan"
  println("Person...")
}

class Emp5 extends Person5{
  println("emp...")

  def this(name:String){
    this
    this.name=name
    println("Emp 辅助构造器")
  }
}

class Person6(pName:String){
  var name="zhangsan"
  println("Person...")

  def this(){
    this("默认的名字")
    println("默认的名字...")
  }
}

class Emp6(eName:String, eAge:Int) extends Person6(eName){
  println("emp...")

  def this(name:String){
    this(name, 100)
    this.name=name
    println("Emp 辅助构造器")
  }
}
