package com.wzl.chapter01_var

object VarDemo01 {

  def main(args: Array[String]): Unit = {
    var age: Int = 10
    var sal: Double = 10.9
    var name: String = "tom"
    var isPass: Boolean = true
    // 小数默认Double 整数默认Int
    var score: Float = 70.9f

    // 类型推导
    var num=10 // Int
    println(num.isInstanceOf[Int])
    // * 类型确定之后，不能修改， num=1.1 错误
    //   说明Scala是强数据类型语言

    // * var修饰的变量可改变
    // * [推荐]val修饰的变量不可变, 没有线程安全问题，效率高
    var age1=10
    age1=11
    val age2=10

    val dog=new Dog
    dog.age=90
    dog.name="123"



    println(s"${age} ${isPass}")
  }

}

class Dog{
  var age: Int=0
  var name: String=""
}
