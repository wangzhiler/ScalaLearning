package com.wzl.chapter12_CRM.service

import com.wzl.chapter12_CRM.bean.Customer

import scala.collection.mutable.ArrayBuffer

class CustomerService {

  // 1. 提供对客户的CRUD
  // 2. 完成相应的任务

  var customerNum=1

  // customers存放客户，为了测试 初始化
  val customers = ArrayBuffer(new Customer(1, "tom", '男'
    , 10, "110", "tom@1.com"))

  def list(): ArrayBuffer[Customer]={
    this.customers
  }

  def add(c:Customer):Boolean={
    customerNum += 1
    c.id=customerNum
    customers.append(c)
    true
  }


  def del(id:Int):Boolean={
    val index=findIndexById(id)
    if(index != -1){
      println("#########"+index)
      customers.remove(index)
      true
    }else{
      false
    }
  }

  def findIndexById(id:Int): Int ={
    var index = -1
    for( i <- 0 until customers.length){
      if(customers(i).id==id){
//        println("####"+i+" "+id)
        return i
      }
    }
//    println("####index:"+index)
    return index
  }

}
