package com.wzl.chapter08_collection

import scala.collection.mutable.ArrayBuffer

object Array01 {

  def main(args: Array[String]): Unit = {

    // 1. 【定长数组1】
    // [Any] 表示该数组可以存放任意类型
    val arr01=new Array[Int](4) // 底层：int[] arr01 = new int[4]
    println(arr01.length)  // 4
    println("arr01(0):"+arr01(0))  // 0
    for(i<-arr01){
      print(i+" ")
    }

    println()

    arr01(3)=10
    for(i<-arr01){
      print(i+" ")
    }

    println("\n----")


    // 2. 【定长数组2】
    // 定义时直接赋值 使用apply方法创建数组对象
    val arr02=Array(1,2,"XXX")
    for(i<-arr02){print(i+" ")}
    println()

    // 下标遍历方式
    for(index <- 0 until arr02.length){
      printf("arr02[%d]=%s", index, arr02(index)+"\t")
    }

    println("\n-----------------------")

    // 3. 【变长数组 ArrayBuffer】
    val arr03=ArrayBuffer[Any](3, 2, 5)
    println("arr03(1)="+arr03(1))
    for(i<-arr03){
      print(i+" ")
    }
    println()
    println(arr03.length)
    println("arr03.hash="+arr03.hashCode())
    // 使用append追加数据，append支持可变参数
    // 可以理解成java数据的扩容
    arr03.append(90.0, 13)
    println("arr03.hash="+arr03.hashCode())

    arr03(1)=89 // 修改
    println("==")
    for(i<-arr03){
      print(i+" ")
    }
    println()
    println("arr03.length:"+arr03.length)

    arr03.remove(0)
    for(i<-arr03){
      print(i+" ")
    }
    println()
    println("最新的长度="+arr03.length)

    println("---------------------------")

    // 4. 【定长数组与变长数组转换】
    // 返回结果才是定长/变长数组，arr01,arr03本身没有变化
    val newArr=arr03.toArray
    println(newArr)

    val newArr2=newArr.toBuffer
    newArr2.append(123)
    println(newArr2)

    println("--------------------------")

    // 5. 【多维数组】
    // 创建3行4列
    val arr04=Array.ofDim[Int](3,4)
    for(item<-arr04){
      for(item2<-item){
        print(item2)
        print(" ")
      }
      println()
    }

    // 指定取出
    println(arr04(1)(1))
    arr04(1)(1)=100
    for(item<-arr04){
      for(item2<-item){
        print(item2)
        print(" ")
      }
      println()
    }

  }
}


























