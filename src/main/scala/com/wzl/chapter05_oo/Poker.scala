package com.wzl.chapter05_oo

object Poker{
  def main(args: Array[String]): Unit = {
    println(Suits)
  }
}

object Suits extends Enumeration {

  type Suits=Value
  val Spade=Value("♠")
  val Club=Value("♣")
  val Heart=Value("❤")
  val Diamond=Value("◇")

  override def toString():String={
    Suits.values.mkString(",")
  }

  def isRed(suit:Suits):Boolean={
    if(suit==Heart|| suit==Diamond){
      true
    }else{
      false
    }
  }

  def isRed2(card:Suits)=card==Heart||card==Diamond
}
