package com.wzl.chapter08_collection

import scala.collection.mutable.ListBuffer

object List01 {

  def main(args: Array[String]): Unit = {

    // 1. 默认List是 immutable 的List 不可变
    // 2. 需要可变List 用ListBuffer
    // 3. immutable.Nil 是个空的List

    val list1=List(1,2,3)
    println(list1)

    val list2=Nil
    println(list2)

    // 访问元素
    val value1=list1(1)
    println("value1:"+value1)

    // 追加 ，返回新的列表，原来的没变化
    // :+ +:
    // 1. 在列表最后增加数据
    val list3=list1:+4
    println(list1)
    println(list3)

    // 2. 在列表最前面增加数据
    val list4=5 +: list1
    println(list1)
    println(list4)

    // 3. 在列表最后增加数据 ::
    // 向集合中添加集合的元素
    val list5=List(1,2,3,"abc")
    // 1. Nil-> 是一个空的List  List()
    // 2. 放入List4 List(List(5,1,2,3))
    // 3. 从右向左 List(4, 5, 6, List(5, 1, 2, 3))
    val list6=4::5::6::list4::Nil
    println(list6)

    // 4. :::
    // 两头都必须为集合
    // 将元素拿出来再放进去
    // List(4, 5, 6, 5, 1, 2, 3)
    val list7=4::5::6::list4:::Nil
    println(list7)


    // 5. ListBuffer
    val lst0=ListBuffer[Int](1,2,3)

    println("lst0(2):"+lst0(2))
    for(item<-lst0){
      print(item+" ")
    }
    println()

    // 添加
    val lst1=new ListBuffer[Int]
    lst1+=4
    lst1.append(5)

    lst0++=lst1

    // lst0:ListBuffer(1, 2, 3, 4, 5)
    println("lst0:"+lst0)

    //
    val lst2=lst0++lst1
    println("lst2:"+lst2)

    val lst3=lst0 :+ 5
    println("lst3:"+lst3)

    // 删除
    println("lst1="+lst1)

    lst1.remove(1)
    for(item<-lst1){
      println("item:"+item)
    }

  }
}


















