package com.wzl.chapter09_collection2

object FlatFilterReduceFold {

  def main(args: Array[String]): Unit = {
    val names=List("Alice","Bob","Nick")

    // 【flatMap】
    val names2=names.flatMap(x=>x.toUpperCase)
    println(names2) // List(A, L, I, C, E, B, O, B, N, I, C, K)


    // 【Filter】
    val names3 = names.filter(x=>x.startsWith("A"))
    println(names3) // List(Alice)


    // 【Reduce】
    // def reduceLeft[B>:A](@deprecatedName('f) op:B,A)=>B):B
    // reduceLeft(f) 接受函数形式为 op:(B,A)=>B):B
    val list=List(1,2,3,4,5)
    val sum=list.reduceLeft((a,b)=>(a+b))
    println(sum)

    // (((1-2)-3)-4)-5
    println(list.reduceLeft(_-_)) // -13

    // 1-(2-(3-(4-5)))
    println(list.reduceRight(_-_)) // 3

    // 等价于 reduceLeft
    println(list.reduce(_-_)) // -13

    // List(3,4,2,7,5)的最小值
    val list2=List(3,4,2,7,5)
    println(list2.reduce((n1,n2)=> if(n1>n2) n2 else n1)) //2


    // 【Fold】
    // ((((5-1)-2)-3)-4)-5
    println(list.foldLeft(5)(_-_)) // -10  // 柯里化
    // 1-(2-(3-4))
    println(list.foldRight(5)(_-_)) // -2

    // foldLeft 和 foleRight 缩写方法分别是 /: :\
    var i1=(1 /: list)(_-_) // 等价于 list.foldLeft(1)(_-_)
    println(i1)
    i1=(100 /: list)(_-_)  // list.foldLeft(100)(_-_)
    println(i1)
    i1=(list :\ 10)(_-_) //list.foldRight(10)(_-_)
    println(i1)




  }

}
