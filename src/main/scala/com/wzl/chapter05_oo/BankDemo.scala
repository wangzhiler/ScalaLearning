package com.wzl.chapter05_oo

object BankDemo {

  def main(args: Array[String]): Unit = {
    val account=new Account("0001", 1000, "123")
    account.query("123")
    account.withDraw("123",1200)
    account.withDraw("123", 10)
    account.query("123")

  }
}

class Account(inAccount:String, inBalance:Double, inPwd:String){
  private val accountNo=inAccount
  private var balance=inBalance
  private var pwd=inPwd

  // 查询
  def query(pwd:String): Unit ={
    if(!this.pwd.equals(pwd)){
      println("wrong")
      return
    }
    println("账号"+this.accountNo+" 余额:"+this.balance)
  }

  def withDraw(pwd:String, money:Double): Any ={
    if(!this.pwd.equals(pwd)){
      println("wrong")
      return
    }
    if(money>this.balance){
      println("余额不足")
      return
    }
    this.balance-=money
    money
  }


}
