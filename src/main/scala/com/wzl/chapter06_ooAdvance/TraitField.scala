package com.wzl.chapter06_ooAdvance

object TraitField {

  def main(args: Array[String]): Unit = {
    new MySQL5 with DB3 {
      override var sal: Int = 1
    }
  }
}

trait DB3{
  // 抽象字段 会在具体的子类中重写
  var sal:Int

  // 父特质的普通字段，被直接加入到混入对象
  // 底层源码中相当于在构造函数中 多声明一个private String opertype
  var opertype:String="insert"
  def insert(): Unit ={

  }
}

class MySQL5
