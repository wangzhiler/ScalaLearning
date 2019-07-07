package com.wzl.chapter10_patternMatching

import scala.collection.mutable.ArrayBuffer

object MatchType {


  def main(args: Array[String]): Unit = {
    val a=5
    val obj=if(a==1) 1
    else if(a==2) "2"
    else if(a==3) BigInt(3)
    else if(a==4) Map("aa" -> 1)
    else if(a==5) Map(1 -> "aa")
    else if(a==6) Array(1,2,3)
    else if(a==7) Array("aa",1)
    else if(a==8) Array("aa")

    val result=obj match{
      case a: Int => a
      case b: Map[String,Int] => "对象为String,Int的Map"
      case c: Map[Int, String] => "对象为Int,String的Map"
      case d: Array[String] => "对象为String数组"
      case e: Array[Int] => "对象为Int的数组"
      case f: BigInt => Int.MaxValue
      case _ => "nothing"
    }

    println(result)

    // 匹配数组
    val array = Array(Array(0), Array(1, 0), Array(0, 1, 0),
      Array(1, 1, 0), Array(1, 1, 0, 1))
    array
    for(arr <- array){
      val result=arr match{
        case Array(0) => "0"
        case Array(x,y) => x+"="+y
        case Array(0, _*) => "以0开头的数组"
        case _ => "nothing"
      }
      println(result)
    }

    // 给定数组集合，Array(x,y) => Array(y,x)
    for(arr <- array){
      val result=arr match{
        case Array(x,y) => Array(y,x).toBuffer
        case _ => "nothing"
      }

      println(result)
//      result match {
//        case buffer: ArrayBuffer[Int] =>
//          println(buffer)
//        case _ =>
//          println(result)
//      }
    }


    // 匹配列表
    for(list <- Array(List(0),List(1,0), List(0,0,0), List(1,0,0), List(8765))){
      val result=list match{
        case 0 :: Nil => "0"
        case x :: y :: Nil => x+" "+y
        case 0 :: tail => "0..."
        case x :: Nil => x
        case _ => "sth else"
      }
      println(result)
    }

    // 匹配元祖
    for(pair <- Array((0,1),(1,0),(10,30),(1,1),(1,0,2))){
      val result=pair match{
        case (0,_) => "0..."
        case (y,0) => y
        case (x,y) => (y,x)
        case _ => "other"
      }
      println(result)
    }
  }
}













