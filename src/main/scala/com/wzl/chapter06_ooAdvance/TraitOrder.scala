package com.wzl.chapter06_ooAdvance

object TraitOrder {
  def main(args: Array[String]): Unit = {
    // class FF extends EE with CC with DD
    // E A B C D F
    // 构造类对象，混入特质时对象还没有创建 所以F在最后
    val ff1=new FF()

    println("==========")

    // 动态混入
    // E K A B C D
    // 构造匿名子类，混入特质时，对象已经创建了
    val ff2=new KK with CC with DD
    println(ff2)


  }
}

trait AA{
  println("A...")
}

trait BB extends AA{
  println("B...")
}

trait CC extends BB{
  println("C...")

}

trait DD extends BB{
  println("D...")

}

trait EE{
  println("E...")

}

class FF extends EE with CC with DD{
  println("F...")

}

class KK extends EE{
  println("K...")

}