package com.wzl.chapter04_package

// 继承App 不用再写main
object Exercise01 extends App {

  /*
   */
  import java.util.{HashMap=>JavaHashMap}
  import collection.mutable.{HashMap=>ScalaHashMap, _}
  val javaMap=new JavaHashMap[Int,String]
  javaMap.put(1, "One")
  javaMap.put(2, "Two")
  javaMap.put(3, "Three")
  val scalaMap=new ScalaHashMap[Int,String]
  // 1. javaMap.keySet().toArray 将javaMap的key转成数组
  for(key <- javaMap.keySet().toArray()) {
    // 2. key.asInstanceOf[Int] 将key转成Int类型
    // 3. javaMap.get(key) 得到key对应的value
    // 4. key.asInstanceOf[Int] -> javaMap.get(key) 是key->value
    // 5. +=将key->value 加入到scalaMap
    scalaMap+=(key.asInstanceOf[Int] -> javaMap.get(key))
  }
  println(scalaMap.mkString(" "))

}
