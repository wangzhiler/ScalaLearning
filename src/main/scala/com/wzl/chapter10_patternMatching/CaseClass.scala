package com.wzl.chapter10_patternMatching

object CaseClass {

  def main(args: Array[String]): Unit = {

    // 样例类案例1
    for(amt <- Array(Dollar(1000.0), Currency(1000.0,"RMB"), NoAmount)){
      val result=amt match {
        case Dollar(v) => "$"+v
        case Currency(x,y) => x+" "+y
        case NoAmount => ""
      }
      println(amt+":"+result)
    }

    // copy
    val amt0 = new Currency(3000.0,"RMB")
    val amt2 = amt0.copy() // 克隆 创建的对象和amt0属性一样
    println("amt2.value:"+amt2.value+" amt2.unit:"+amt2.unit)

    val amt3=amt0.copy(value=8000.0)
    println(amt3)
    val amt4=amt0.copy(unit="泰铢")
    println(amt4)

  }
}

abstract class Amount
case class Dollar(value:Double) extends Amount
case class Currency(value:Double, unit:String) extends Amount
case object NoAmount extends Amount
