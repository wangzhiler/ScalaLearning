package com.wzl.chapter12_CRM.view

import com.wzl.chapter12_CRM.bean.Customer
import com.wzl.chapter12_CRM.service.CustomerService

import scala.io.StdIn

class CustomerView {
  // 1. 显示界面
  // 2. 接受用户的请求 添加/显示/删除
  // 3. 调用业务逻辑层代码完成（对客户的CRUD）


  // 定义一个循环变量，控制是否退出while
  var loop = true

  // 定义一个个key用于接受用户输入的选项
  var key = ' '

  val customerService=new CustomerService()

  def mainMemu():Unit={
    do{
      println()
      println("----------客户信息管理软件----------")
      println("          1. 添加客户")
      println("          2. 修改客户")
      println("          3. 删除客户")
      println("          4. 客户列表")
      println("          5. 退    出")
      println("请选择(1-5)")

      key=StdIn.readChar()
      key match{
        case '1' => this.add()
        case '2' => println("修改客户")
        case '3' => this.del()
        case '4' => this.getList()
        case '5' => this.loop=false
      }

    }while(loop)
    println("你退出了软件系统...")

  }

  def add()={
    println()
    println("----------添加客户----------")
    println("姓名：")
    val name = StdIn.readLine()
    println("性别：")
    val gender = StdIn.readChar()
    println("年龄：")
    val age = StdIn.readShort()
    println("电话：")
    val tel = StdIn.readLine()
    println("邮箱：")
    val email = StdIn.readLine()

    val customer=new Customer(name,gender,age,tel,email)
    customerService.add(customer)
    println("----------添加客户完成----------")
  }


  def del():Unit={
    println()
    println("----------删除客户----------")
    println("请输入待删除的编号(-1退出)")
    val id=StdIn.readInt()
    if(id== -1){
      println("----------删除客户没有完成----------")
      return
    }
    println("确认是否删除(Y/N)")
    val choice=StdIn.readChar().toLower
    if(choice=='y'){
      if(customerService.del(id)){
        println("----------删除客户完成----------")
        return
      }
    }
    println("----------删除客户完成----------")
  }

  def getList()={
    println()
    println("----------客户列表----------")
    println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱\t\t")
    val customers=customerService.list()
    for (c <- customers) {
      println(c)
    }
    println("----------客户列表完成----------")
  }

}
