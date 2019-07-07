package com.wzl.chapter09_collection2

object ViewParallel {

  def main(args: Array[String]): Unit = {

    // 【View】
    // view产出一个lazy集合
    // view不会缓存数据

    def multiple(num:Int):Int={
      num
    }
    def eq(i:Int):Boolean={
      i.toString.equals(i.toString.reverse)
    }

    // 没有使用view
    val viewSquares1=(1 to 100).map(multiple)
      .filter(eq)
    println(viewSquares1) // Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99)

    // for(x<-viewSquare1){}

    // 使用view
    val viewSquares2=(1 to 100).view.map(multiple).filter(eq)
    println(viewSquares2) // SeqViewMF(...) // lazy加载 这里不调用eq

    // 遍历
    for(item <-viewSquares2) {
      println("item:"+item)
    }


    // 【parallel】
    // 并行集合
    // Divide and conquer: 分治算法
    // Work stealin: 用于任务调度负载均衡
    (1 to 5).foreach(println(_)) // 1 2 3 4 5
    println()
    (1 to 5).par.foreach(println(_)) // 2 4 3 1 5

    // 查看并行集合中元素访问的线程
    val result1=(0 to 100).map{case _=> Thread.currentThread.getName}
    val result2=(0 to 100).par.map{case_ => Thread.currentThread.getName}
    println(result1) // Vector(main, main, main, main, main, main...)
    println(result2) // ParVector(ForkJoinPool-1-worker-3, ForkJoinPool-1-worker-3...)
  }
}
