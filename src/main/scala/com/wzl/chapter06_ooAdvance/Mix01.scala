package com.wzl.chapter06_ooAdvance

object Mix01 {
  def main(args: Array[String]): Unit = {
    // 在不修改类的定义基础上，动态混入
    val oracleDB=new OracleDB with Operate
    oracleDB.insert(1)

    val mysql2=new MySQL2 with Operate
    mysql2.insert(2)

    val mysql3 = new MySQL3 with Operate {
      override def say(): Unit = {
        println("say...")
      }
    }
    mysql3.insert(3)
    mysql3.say()
  }
}

trait Operate{
  def insert(id:Int): Unit ={
    println("插入数据="+id)
  }
}

class OracleDB{} // 空

abstract class MySQL2{} // 空抽象类

abstract class MySQL3{
  def say()
}