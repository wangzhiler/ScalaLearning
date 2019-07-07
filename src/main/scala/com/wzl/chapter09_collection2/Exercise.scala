package com.wzl.chapter09_collection2

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Exercise {

  def main(args: Array[String]): Unit = {

    // 1. 通过foldLeft将setence存放到一个ArrayBuffer中
    val sentence="AAAAAAAAAABBBBBBBBCCCCCDDDDDDDD"

    val arr=ArrayBuffer[Char]()
    sentence.foldLeft(arr)((array:ArrayBuffer[Char], c:Char)=>{
      array.append(c)
      array
    })
    println(arr)

    def putArray(arr:ArrayBuffer[Char], c:Char): ArrayBuffer[Char] ={
      arr.append(c)
      arr
    }


    // 2. 统计各个字母出现次数 Map[Char, Int]()

    // 不可变map
    def charCount(map:Map[Char,Int], c:Char):Map[Char,Int]={
      map+(c->(map.getOrElse(c,0)+1))
    }
    // 可变map
    def charCount2(map:mutable.Map[Char,Int], char:Char):mutable.Map[Char,Int]={
      map+=(char->(map.getOrElse(char,0)+1))
    }

    val map2 = sentence.foldLeft(Map[Char,Int]())(charCount)
    println(map2) // Map(A -> 10, B -> 8, C -> 5, D -> 8)

    // 使用可变map效率更高
    val map3 = mutable.Map[Char,Int]()
    sentence.foldLeft(map3)(charCount2)


  }

}
