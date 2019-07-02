package com.wzl.chapter08_collection

import scala.collection.mutable.ArrayBuffer

object ArrayBuffer2JavaList {

  def main(args: Array[String]): Unit = {
    val arr=ArrayBuffer("1","2","3")

    import scala.collection.JavaConversions.bufferAsJavaList

    // 对象 ProcessBuilder
    val javaArr=new ProcessBuilder(arr)
    // arrList 就是 java中的List
    val arrList=javaArr.command()
    println(arrList) //[1,2,3]

    // java List->Scala ArrayBuffer
    import scala.collection.JavaConversions.asScalaBuffer
    import scala.collection.mutable

    val scalaArr:mutable.Buffer[String]=arrList
    scalaArr.append("jack")
    scalaArr.append("tom")
    scalaArr.remove(0)
    println(scalaArr)

  }
}
