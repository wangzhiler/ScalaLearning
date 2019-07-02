package com.wzl.chapter08_collection

import scala.collection.mutable

object Queue01 {

  def main(args: Array[String]): Unit = {

    val q1=new mutable.Queue[Any]
    println(q1)

    q1+=20
    println(q1)

    q1++=List(1,2,3) // 将List元素一个一个放进去
    println(q1)

    q1 += List(10,0) // List(10,0) 作为一个元素放入，要求Any类型
    println(q1)


    // 队列
    // 头出 dequeue
    // 尾进 enqueue
    val queueElement=q1.dequeue()
    println(queueElement+" "+q1) // 20 Queue(1, 2, 3, List(10, 0))

    q1.enqueue(100, 10, 100)
    println(q1) // Queue(1, 2, 3, List(10, 0), 100, 10, 100)


    // 取元素 不删元素
    // head 队列第一个元素
    println(q1.head) // 1

    // last 队列最后一个元素
    println(q1.last) // 100

    // tail 除了第一个元素以为剩余的元素
    println(q1.tail) // Queue(2, 3, List(10, 0), 100, 10, 100)

  }
}
