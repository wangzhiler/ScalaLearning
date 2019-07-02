package com.wzl.chapter08_collection

import scala.collection.mutable

object Map01 {

  def main(args: Array[String]): Unit = {

    //=================== 创建
    // 不可变映射
    // 默认Map是 immutable.Map
    // key-value 类型支持Any
    // 在Map底层 每队 key-value 都是Tuple2
    val map1=Map("Alice"->10, "Bob"->20, "Kotlin"->"aa")
    println(map1)

    // 可变映射
    // 输出顺序和声明顺序不一致
    val map2=mutable.Map("Alice"->10, "Bob"->20, "Kotlin"->"aa")
    println(map2)

    // 创建空的映射
    val map3=new mutable.HashMap[String, Int]
    println(map3)

    // 对偶元组
    val map4=mutable.Map(("Alice", 10),("Bob",20))
    println(map4)

    // ================== 取值

    // 1. map(key) 取元素 没有key则抛出异常
    println(map4("Alice"))
//    println(map4("Alice~")) //NoSuchElementException

    // 2. contains 方法检查是否存在key
    if(map4.contains("Alice~")){
      println(map4("Alice~"))
    }else{
      println("key不存在")
    }

    // 3. map.get(key).get
    // 映射.get(key) 返回一个 Option
    // map.get(key)存在 则返回Some Some(值).get可以取出value
    // map.get(key)不存在 则返回None
    println(map4.get("Alice"))  //Some(10)
    println(map4.get("Alice").get)
    println(map4.get("Alice~"))


    // 4. map.getOrElse()
    // key存在 返回value
    // key不存在 返回默认值
    println(map4.getOrElse("Alice","aaa"))
    println(map4.getOrElse("Alice~","aaa"))

    // * 当确定map有key 用map(key) 速度快
    //   当不确定，且有不同业务逻辑 用constains
    //   如果仅需获得值， getOrElse

    //================== 更新
    map4("Alice")=2
    map4("AAAAA")=10

    map4+=("D"->10)
    map4+=("E"->11,"F"->12)
    println(map4)
    // Map(D -> 10, Bob -> 20, AAAAA -> 10, F -> 12, Alice -> 2, E -> 11)


    //================= 删除
    // key不存在 不报错
    map4 -= ("D","E","G")
    println(map4) // Map(Bob -> 20, AAAAA -> 10, F -> 12, Alice -> 2)


    //================= 遍历
    for((k,v)<-map2) println(k+" is mapped to "+v)
    println("===")
    for(v <- map2.keys) println(v)
    println("===")
    for(v <- map2.values) println(v)
    println("===")
    for(v <- map2) println(v+" "+v._1+" "+v._2) // 类型是Tuple2

  }
}









