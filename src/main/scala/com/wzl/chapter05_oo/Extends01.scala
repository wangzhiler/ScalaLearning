package com.wzl.chapter05_oo

object Extends01 {

  // 子类继承父类所有方法，但是private的属性和方法无法访问
  def main(args: Array[String]): Unit = {

  }
}


class Base{
  var n1:Int=1 // 本质 public n1() public n1_$eq()
  protected var n2:Int=2
  private var n3:Int=3 // 本质 private n3() private n3_$eq()

  def test100(): Unit ={
    println("base 100")
  }

  protected def test200(): Unit ={
    println("base 200")
  }

  private def test300(): Unit ={
    println("base 300")
  }
}

class Sub extends Base{
  def sayOk(): Unit ={
    this.n1=20
    this.n2=40
    println("范围"+this.n1+this.n2)

    test100()
    test200()
  }
}
