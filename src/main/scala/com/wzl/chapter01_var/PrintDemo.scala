package com.wzl.chapter01_var

object PrintDemo {

  def main(args: Array[String]): Unit = {
    var str1: String = "hello"
    var str2: String = "world"

    println(str1 + str2)

    var name: String="tom"
    var age: Int=10
    var sal: Float=10.67f
    var height: Double=180.15

    // 格式化输出
    printf("名字=%s 年龄是%d 薪水%.2f 高%.3f", name, age, sal, height)

    // scala支持使用$输出内容
    println(s"个人信息如下：\n 名字$name 年龄$age 薪水$sal 高$height")

    // 有运算的动作可以括号括起来
    println(s"个人信息如下：\n 名字$name 年龄${age+10} 薪水${sal*10} 高$height")
  }
}
