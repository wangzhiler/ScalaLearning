package com.wzl.chapter08_collection

import scala.collection.mutable

object Set01 {

  def main(args: Array[String]): Unit = {
    // 默认 不可变
    val set=Set(1,2,3)
    println(set)

    val set2=mutable.Set(1,2,"hello")  //可变
    println(set2)

    // 添加
    set2.add(4)
    set2+=5
    set2+=1
    println(set2)

    // 删除
    set2-=2
    set2.remove("hello")
    set2-="remove"
    println(set2)

    // 遍历
    for(x<-set2){
      println(x)
    }
  }
}
