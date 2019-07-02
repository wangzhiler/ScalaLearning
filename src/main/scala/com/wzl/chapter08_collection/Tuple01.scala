package com.wzl.chapter08_collection

object Tuple01 {

  def main(args: Array[String]): Unit = {

    // 1. tuple1就是一个Tuple，类型是Tuple5
    //    为了高效的操作元祖，编译器根据元素的个数 对应不同的元组类型
    //    分别为 Tuple1~Tuple22
    val tuple1=(1,2,3,"hello",4)

    // 访问元组的第一个元素
    println(tuple1._1)  // 从1开始
    println(tuple1.productElement(0)) //从0开始
    // productElement源码中 case 0 => _1

    // 遍历，需要迭代器
    for(item<-tuple1.productIterator){
      println("item:"+item)
    }
  }
}
