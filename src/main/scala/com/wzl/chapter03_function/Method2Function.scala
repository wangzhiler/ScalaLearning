package com.wzl.chapter03_function

object Method2Function {

  def main(args: Array[String]): Unit = {

    val dog = new Dog
    println(dog.sum(20,10))

    // 方法转成函数
    val f1=dog.sum _
    println("f1="+f1)
    println("f1="+f1(50,60))

    // 函数,求两个数的和
    val f2=(n1:Int, n2:Int) => {
      n1+n2 // 函数体
    }
    println("f2="+f2(15,25))

  }


}

class Dog{
  def sum(n1: Int, n2: Int):Int={
    n1+n2
  }

}
