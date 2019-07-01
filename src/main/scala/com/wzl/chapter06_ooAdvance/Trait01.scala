package com.wzl.chapter06_ooAdvance


// trait ≈ interface + abstract class
object Trait01 {

  def main(args: Array[String]): Unit = {
    val c=new C()
    val f=new F()
    c.getConnect()
    f.getConnect()

    //----
    val sheep=new Sheep()
    sheep.sayAbstract()
    sheep.sayNormal()
  }
}

// scala中 java的接口都可以当做trait使用
// trait Serializable extends Any with java.io.Serializable
object T1 extends Serializable{}

// 如果没有父类
// trait Xxx extends trait1 with trait2 ...
// 有父类
// traut Xxx extends 父类 with trait1 ...


//
trait Trait1{
  def getConnect()
}

class A{}

class B extends A{}
class C extends A with Trait1 {
  override def getConnect(): Unit = {
    println(",.,,")
  }
}

class D{}
class E extends D{}
class F extends D with Trait1 {
  override def getConnect(): Unit = {
    println("njkl")
  }
}

// 富接口：特质中既有抽象方法，又有非抽象方法
// 1. 当Trait只有抽象方法时，实现机制和Java完全一致
// 2. 当Trait有抽象方法和非抽象方法时，底层对应两个类
//    Trait2.class 接口
//    Trait2$class.class Trait2$class抽象类
trait Trait2{
  // abstract
  def sayAbstract()
  // normal
  def sayNormal(): Unit ={
    println("say Normal")
  }
}

// class Sheep extends Trait2 在底层 对应
// class Sheep implements Trait2
// 当在Sheep类中使用Trait2实现的方法，通过Trait2$class
class Sheep extends Trait2{
  override def sayAbstract(): Unit = {
    println("say abstract")
  }
}