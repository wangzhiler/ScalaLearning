package com.wzl.chapter06_ooAdvance

import com.wzl

object ScalaInner {
  def main(args: Array[String]): Unit = {

    // 1. 创建两个外部类实例
    val outer1: ScalaOuterClass=new ScalaOuterClass
    val outer2: ScalaOuterClass=new ScalaOuterClass

    // 2. 创建成员内部类实例
    // 对象.内部类 的方法创建，这里语法可以看出在scala中
    // 默认情况下内部类实例和外部对象关联
    val inner1=new outer1.ScalaInnerClass
    val inner2 = new outer2.ScalaInnerClass

    inner1.info()
    inner1.test(inner2)
    inner2.test(inner1)

    // 3. 创建静态内部类实例
    val static = new wzl.chapter06_ooAdvance.ScalaOuterClass.ScalaStaticInnerClass

    //
    println("======")

    // 1. 创建两个外部类实例
    val outer3: ScalaOuterClass2=new ScalaOuterClass2
    val outer4: ScalaOuterClass2=new ScalaOuterClass2

    // 2. 创建成员内部类实例
    // 对象.内部类 的方法创建，这里语法可以看出在scala中
    // 默认情况下内部类实例和外部对象关联
    val inner3=new outer3.ScalaInnerClass2
    val inner4 = new outer4.ScalaInnerClass2

    inner3.info()

    // 3. 创建静态内部类实例
    val static2 = new wzl.chapter06_ooAdvance.ScalaOuterClass2.ScalaStaticInnerClass2

  }
}

// 内部类访问外部类的属性方法1
// 外部类名.this.属性名
class ScalaOuterClass{
  var name="scoot"
  private var sal=3000.9

  class ScalaInnerClass{
    // 成员内部类

    // 访问外部：外部类名.this.属性名
    // ScalaOuterClass.this 相当于ScalaOuterClass 这个外部类的一个实例
    // 通过实例访问name属性
    def info(): Unit ={
      println("name:"+ScalaOuterClass.this.name+" sal:"+ScalaOuterClass.this.sal)
    }

    // 接受ScalaInnerClass的实例
    // Java中内部类从属于外部类
    // Scala中内部类从属于外部类的对象，所以外部类的对象不一样，则内部类也不一样
    // 外部类#内部类
    // 投影的作用就是屏蔽外部对象对内部类对象的影响
    def test(ic:ScalaOuterClass#ScalaInnerClass): Unit ={
//    def test(ic:ScalaInnerClass): Unit ={
      println("投影"+ic)
    }
  }
}

object ScalaOuterClass{
  class ScalaStaticInnerClass{
    // 静态内部类
  }
}

//===============================

// 使用别名的方式
class ScalaOuterClass2{

  myOuter =>
  class ScalaInnerClass2{
    // 成员内部类

    // 访问外部：外部类别名.属性名
    // ScalaOuterClass.this 相当于ScalaOuterClass 这个外部类的一个实例
    // 通过实例访问name属性
    def info(): Unit ={
      println("name2:"+myOuter.name+" sal2:"+myOuter.sal)
    }
  }

  var name="scoot222"
  private var sal=6000.9
}

object ScalaOuterClass2{
  class ScalaStaticInnerClass2{
    // 静态内部类
  }
}
