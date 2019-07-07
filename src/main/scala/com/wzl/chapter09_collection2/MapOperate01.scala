package com.wzl.chapter09_collection2

object MapOperate01 {

  def main(args: Array[String]): Unit = {
    val list1=List(3,5,7)
    var list2=List[Int]()
    for(item<-list1){
      list2=list2:+item*2
    }
    println(list2)

    // def map[B](f:(A)=>B):HashSet[B]


    list2=list1.map(multiple)
    val list3 = list1.map(x=>x*2)
    println(list3)

    val myList=MyList()
    val list4 = myList.map(multiple)
    println(list4)

    val names=List("Alice","Bob","aa")
    val names2=names.map(x=>x.toUpperCase)
    println(names2)

  }


  def multiple(n:Int):Int={
    2*n
  }

}

// map机制 模拟实现
class MyList{
  val list1=List(1,3,5,7)
  var list2=List[Int]()

  def map(f:Int=>Int):List[Int] = {
    //遍历集合
    for(item<-this.list1){
      list2=list2:+ f(item)
    }
    list2
  }
}

object MyList{
  def apply(): MyList = new MyList()
}
