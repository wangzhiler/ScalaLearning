package com.wzl.chapter06_ooAdvance

object AddTrait {

  // Scala中特质如调用super，会先向前查找特质，找不到再去父类找

  def main(args: Array[String]): Unit = {

    // Scala在叠加特质的时候，从左到右
    // 动态混入db1和file1
    // Operate2
    // data
    // db1
    // file1
    val mysql=new MySQLL with DB1 with File1
//    println(mysql)

    // Scala中特质如调用super，会先向前查找特质，找不到再去父类找
    // 类似栈
    // 向文件
    // 向数据库
    // 插入数据=100
    mysql.insert(100)

    //------
    val mysql2=new MySQLL with File1 with DB1
    mysql2.insert(999)
  }
}

trait Operate2{
  println("Operate2...")
  def insert(id:Int) // 抽象方法
}

trait Data extends Operate2{
  println("Data")
  override def insert(id: Int): Unit = {
    println("插入数据="+id)
  }
}

trait DB1 extends Data{
  println("DB1")

  override def insert(id: Int): Unit = {
    println("向数据库")
    super.insert(id)
  }
}

trait File1 extends Data{
  println("File1")

  override def insert(id: Int): Unit = {
    println("向文件")
//    super.insert(id) // 调用了insert方法，这里super在动态混入时，不一定是父类
    // 如果我们希望直接调用Data的insert方法
    // 说明 super[?] ?的类型必须是当前特质的直接父特质(超类)
    super[Data].insert(id)
  }
}

class MySQLL{}


