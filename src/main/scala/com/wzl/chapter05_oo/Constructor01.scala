package com.wzl.chapter05_oo

object Constructor01 {

  def main(args: Array[String]): Unit = {
    val p1=new Person1("accc",12)
    println(p1)

    val p2=new Person1("qqqq")
    println(p2)

    val aa=new AA()
  }
}

// Constructor
class Person1(s:String, a:Int){
  var name:String=s
  var age:Int=a
  age+=3
  println("after age+=3")

  override def toString: String = {
    "name:"+this.name+" age:"+this.age
  }

  println("~~~")

  // 辅助构造器，必须在第一行显示调用主构造器
  def this(name:String){
    this("jack",1)
    this.name=name
  }
}

class BB{
  println("b~~~")
}

class AA extends BB{
  def this(name:String){
    this //调用A的主构造器
    println("A this(name:String)")
  }
}

class Person2(){
  var name:String=_
  var age:Int=_

  def this(name:String){
    this()
    this.name=name
  }

  def this(name:String, age:Int){
    this()  // 直接调用主构造器
    this.name=name
    this.age=age
  }

  def this(age:Int){
    this("匿名") // 间接调用主构造器
    this.age=age
  }

}




