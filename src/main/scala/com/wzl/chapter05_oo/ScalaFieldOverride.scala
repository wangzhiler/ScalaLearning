package com.wzl.chapter05_oo

// 表面是字段复写，本质是方法复写

// def 只能重写一个def
// val 只能重写一个val 或者 重写不带参数的def

// var 只能重写另一个抽象的var

object ScalaFieldOverride {
  def main(args: Array[String]): Unit = {
    val obj1:A3=new B3
    val obj2:B3=new B3
    println(obj1.age+" "+obj2.age)

    // b3.name="kac" 相当于调用了父类的name_$eq()
    // b3.name 相当于调用了子类的name()
    // 数据设置和数据获取不一致
  }
}

class A3{
  val age:Int=10  // 会生成 public age()
  var name:String="" // 底层会生成 public name() 和 public name_$eq()
  def sal():Int={
    return 10
  }
}

class B3 extends A3{
  override val age:Int=30 // 会生成 public age()
//  override val name:String ="qq" // 会生成 public name()
  override val sal:Int=0
}

// 抽象字段
// 1. 抽象的字段：没有初始化的字段
// 2. 当一个类含有抽象属性，要讲类标记abstract
// 3. 对于抽象的属性，底层不会生成对应的属性声明，而是生成两个对应的抽象方法(name name_$eq)
abstract class A4{
  var name:String
}

class SubA4 extends A4{
  // override写不写都可以
  var name:String=""
}
