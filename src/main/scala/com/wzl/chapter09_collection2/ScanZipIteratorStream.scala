package com.wzl.chapter09_collection2

object ScanZipIteratorStream {

  def main(args: Array[String]): Unit = {

    // 【scan】
    // 返回运算中间结果
    var i2=(1 to 5).scanLeft(5)(_-_)
    println(i2) // Vector(5, 4, 2, -1, -5, -10)

    i2 = (1 to 5).scanRight(5)(_-_)
    println(i2) // Vector(-2, 3, -1, 4, 0, 5)


    // 【Zip】
    val l1=List(1,2,3)
    val l2=List(4,5,6)
    val l3=l1.zip(l2)
    println(l3)


    // 【Iterator】
    var iterator=List(1,2,3,4,5).iterator
    println("------遍历方式1")
    while(iterator.hasNext){
      println(iterator.next())
    }

    iterator=List(1,2,3,4,5).iterator
    println("------遍历方式2")
    for(enum<-iterator){
      print(enum+" ")
    }
    println()


    // 【Stream】
    // stream是一个集合，可以用于存放无穷多个元素，氮元素不会一次性生产出来，遵循lazy
    def numsForm(n:BigInt):Stream[BigInt]=n #:: numsForm(n+1)
    val stream1=numsForm(1)
    println(stream1) // Stream(1,?)
    // 取出第一个元素
    println("stream:\n"+stream1.head) // 1
    println(stream1.tail) // Stream(2,?) // 会生成一个新的数据
    println(stream1) // Stream(1,2,?)

    // 应用案例
    def multi(x:BigInt):BigInt={x*x}
    println(numsForm(5).map(multi)) //Stream(25,?)

  }
}
