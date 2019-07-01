package com.wzl.chapter05_oo

object CatDemo {
  def main(args: Array[String]): Unit = {
     val cat=new Cat
    cat.color="reddd"

    println(cat.toString)

    // 当val的类型和new对象类型有继承关系即多态时，必须写
    val emp=new Emp
    val emp2:Person=new Emp
  }
}

class Cat{
  var name:String=""
  var age:Int=_
  var color:String=_

  //_表示给一个默认值，Int为0 String为null Boolean:false
}

class Person{

}

class Emp extends Person{

}