package com.wzl.chapter04_package

object PackageVisible {

  def main(args: Array[String]): Unit = {
    val c=new Clerk()
    c.showInfo()
    Clerk.test(c)

    val p1=new Person
    println(p1.name)
  }
}

class Clerk{
  var name:String="jack"
  private var sal:Double=9.9
  def showInfo(): Unit ={
    println("name:"+name+" sal:"+sal)
  }
}


// 当一个文件中出现了class Clerk 和 object Clerk
// 1. class Clerk 称为伴生类
// 2. object Clerk 的伴生对象
// 3. 因为scala将static去掉，设计了伴生类和伴生对象的概念
// 4. 半生类 写非静态的内容
//    伴生对象 静态内容
object Clerk{
  def test(c:Clerk): Unit ={
    // 私有属性在伴生对象中也可以访问
    println("test() name:"+c.name+" sal:"+c.sal)
  }
}

class Person{
  // 任然是private 但是扩大了访问范围，chapter05_package包也可以访问了
  private[chapter04_package] val name="ka"
}