package com.wzl.chapter07_implicit

object Implicit01 {
  def main(args: Array[String]): Unit = {

    // 定义域内隐式函数的匹配得是唯一的

    // 编写一个隐式函数转成 Double->Int 转换
    implicit def f1(d:Double):Int={
      // 底层生成 f1$1
      d.toInt
    }

    implicit def f2(f:Float):Int={
      f.toInt
    }

    val num:Int=3.5 // 底层编译 f1$1(3.5)
    val num2:Int=6.7f
    println(num+" "+num2)

    //===================

    // 隐式转换丰富类库功能
    implicit def addDelete(mysql:MySQL):DB={
      new DB
    }
    val mysql=new MySQL
    mysql.insert()
    mysql.delete() // 相当于addDelete$1(mysql).delete()
    mysql.update()
  }

}

class MySQL{
  def insert(): Unit ={
    println("insert")
  }
}

class DB{
  def delete(): Unit ={
    println("delete")
  }

  def update(): Unit ={
    println("update")
  }
}