package com.wzl.chapter11_functionalProgramming

import java.text.SimpleDateFormat
import java.util.Date

object Recursion01 {

  def main(args: Array[String]): Unit = {

    // 计算1-50的和，使用常规的while来完成
    val now:Date=new Date()
    val dateFormat: SimpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date=dateFormat.format(now)
    println("执行前的时间date="+date)

    var res=BigInt(0) // 存放计算的结果
    var num=BigInt(1) // num变化的数
    var maxVal=BigInt(99999999l) // BigInt(99999999L)[测试效率大数]
    while(num <= maxVal){
      res+=num // 累计
      num+=1 // 变量的叠加
    }
    println("res="+res)

    val now2:Date=new Date()
    val date2=dateFormat.format(now2)
    println("执行完毕的时间date2="+date2)

    //------------------------------------------

    val now3:Date=new Date()
    val date3=dateFormat.format(now3)
    println("执行前的时间date3="+date3)

    var num1=BigInt(1)
    var sum=BigInt(0)
    var res1=mx(num1,sum)
    println(res1)

    val now4:Date=new Date()
    val date4=dateFormat.format(now4)
    println("执行完毕的时间date4="+date4)


  }

  // 递归的方式统计 1+num
  def mx(num:BigInt, sum:BigInt):BigInt={
    if(num<=99999999l) return mx(num+1, sum+num)
    else return sum
  }
}
