package com.wzl.chapter01_var

object TypeDemo02 {

  def main(args: Array[String]): Unit = {
    println(sayHello)
  }

  var num=1.2 //Double
  var num1=1.1f //float
  num1=num.toFloat

  // 比如开发中，我们有一个方法，就会异常中断，这是就可以返回Nothing
  // 即当我们Nothing做返回值，就是明确说明该方法没有正常返回值
  def sayHello: Nothing={
    throw new Exception("抛出异常")
  }
}
