package com.wzl.chapter04_package

import scala.collection.mutable


object PackageImport {

  def main(args: Array[String]): Unit = {

  }
}

class User{
  import scala.beans.BeanProperty // 需要时引入
  @BeanProperty var name:String=""

  def test(): Unit ={
    // 可以使用选择器
    import scala.collection.mutable.{HashMap, HashSet}
    var map=new HashMap()
    var set=new HashSet()
  }

  def test2(): Unit ={
    // 可以重命名
    import java.util.{ HashMap => JavaHashMap, List}
    import scala.collection.mutable._
    var map=new HashMap()
    var map2=new JavaHashMap()
  }

  def test3(): Unit ={
    // 引入util所有类，除了HashMap
    import java.util.{HashMap=>_, _}
//    var map=new HashMap()
  }


}

class Dog{

}
