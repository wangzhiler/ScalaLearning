package com.wzl.chapter02_control

object For01 {

  def main(args: Array[String]): Unit = {


    val start=1
    val end=10

    // for 【to】 1-10
    for(i <- start to end) {
      print(" ajdls"+i)
    }

    println("")

    // 说明for这种推导 可以直接对集合进行遍历
    val list= List("hello", 10, 30, "tom")
    for(item <- list) {
      print(" item="+item)
    }

    println("")


    // for 【until】 1-9
    for(i <- start until end) {
      print(" acakd"+i)
    }

    println("")


    // 【循环守卫】
    // 保护式为true则进入循环体，为false则跳过，类似continue
    for(i <- 1 to 3 if i!=2) {
      print(i+" ")
    }

    println("")


    // 【引入变量】
    for(i <- 1 to 3; j=4-i) {
      print(j+" ")
    }
    /*
    上面这个相当于：
    for(i<-1 to 3){
      val j=4-i
      print(j+" ")
    }
     */
    // 也等价于
    for{
      i <- 1 to 3
      j = 4 - i
    }{
      print(j+" ")
    }

    println("")


    // 【嵌套循环】
    for(i <- 1 to 3; j <- 1 to 3) {
      print("i="+i+" j="+j+"   ")
    }
    /* 等价于
    for(i<-1 to 3){
      for(j<-1 to 3){
        println(...)
      }
    }
     */

    println("")


    // 【循环返回值】
    // var res=for(i <- 1 to 10) yield i
    // 1) 对 1 to 10 进行遍历
    // 2) yield i 将每次循环得到i 放入集合Vector中，返回给res
    // 3) i这里是一个代码块，意味着可以对i进行处理
    // 4) 这个处理方式体现Scala一个重要语法特点，将一个集合中各个数据进行处理，并返回给新的集合
    var res=for(i <- 1 to 10) yield {
      if(i%2==0){
        i
      }else{
        "abc"
      }
    }
    println(res)


    // 【控制步长】
    for( i<-1 to 10){
      print(" i="+i)
    }

    // 步长控制为2
    for(i<-Range(1,10,2)) {
      print("   i="+i)
    }

    // for循环守卫
    for(i<- 1 to 10 if i%2==1) {
      print("   i="+i)
    }

  }



}
