package com.wzl.chapter09_collection2

object OperatorOverload {

  def main(args: Array[String]): Unit = {
    val n1=1
    val n2=2
    val r1=n1+n2
    val r2=n1.+(n2)

    val monster=new Monster
    monster+10
    monster.+(10)
    monster++

    !monster

    println("monster.money:"+monster.money)
  }
}

class Monster{
  var money:Int=0

  // 中置操作符
  def +(n:Int)={
    this.money += n
  }

  // 后置操作符
  def ++()={
    this.money += 1
  }

  // 前置操作符 一元运算符
  def unary_!()={
    this.money= -this.money
  }
}
