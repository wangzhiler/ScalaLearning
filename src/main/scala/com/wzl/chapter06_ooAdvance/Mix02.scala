package com.wzl.chapter06_ooAdvance

object Mix02 {
  def main(args: Array[String]): Unit = {
    // 将数据保存到文件中
    // DB insert
    val mySQL4 = new MySQL4 with DB2 with File2
    mySQL4.insert(666)
  }
}

trait Operate3{
  def insert(id:Int)
}

trait File2 extends Operate3{

  // 1. 如果子特质中重写/实现了一个父特质的抽象方法，但是同时调用super
  //    这时方法是不能完全实现的，需要声明为abstract override
  //    super.insert(id)的调用和动态混入顺序有密切关系
  abstract override def insert(id: Int): Unit = {
    println("将数据保存到文件中")
    super.insert(id)
  }
}

trait DB2 extends Operate3{
  override def insert(id: Int): Unit = {
    println("DB insert")
  }
}

class MySQL4{

}