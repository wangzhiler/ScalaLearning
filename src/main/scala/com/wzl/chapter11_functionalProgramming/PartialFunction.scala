package com.wzl.chapter11_functionalProgramming

object PartialFunction {

  // val list=List(1,2,3,4,"abc")
  // 1. 对所有数字+1 返回新的集合
  // 2. 忽略 非数字 的元素，返回 (2,3,4,5)

  def main(args: Array[String]): Unit = {

    val list=List(1,2,3,4,"abc")

    // 1. filter + map
    val list2=list
      .filter(_.isInstanceOf[Int])
      .map(_.asInstanceOf[Int])
      .map(_+1)
    println(list2)


    // 2. 模式匹配 有瑕疵
    def addOne(i:Any):Any={
      i match {
        case x:Int => x+1
        case _ =>
      }
    }
    val list3 = list.map(addOne)
    println(list3) // List(2, 3, 4, 5, ())



    // 3. 偏函数
    // 定义一个偏函数
    // 1) PartialFunction[Any,Int] 表示接受参数是Any类型，返回Int
    // 2) isDefined如果返回true 就会调用apply构建实例
    // 3) apply实现代码返回到新的集合
    val partialFun = new PartialFunction[Any,Int]{
      override def isDefinedAt(x: Any):Boolean= x.isInstanceOf[Int]

      override def apply(v1: Any): Int = {
        v1.asInstanceOf[Int]+1
      }
    }

    // 使用偏函数 用collect,collect类似于结合了filter和map
    val list4 = list.collect(partialFun)
    println(list4)


    // 偏函数简化形式
    def f: PartialFunction[Any,Int]={
      case i:Int => i+1
      case j:Double => (j*2).toInt
    }
    val list5=list.collect(f)
    println(list5)

    val list6=list.collect{case i:Int => i+1}
    println(list6)

  }
}



























