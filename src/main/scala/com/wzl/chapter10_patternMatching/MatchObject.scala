package com.wzl.chapter10_patternMatching

object MatchObject {

  def main(args: Array[String]): Unit = {
    // case 中对象的 unapply 方法（对象提取器）返回 Some集合则为匹配成功
    // 返回none则匹配失败

    val number:Double=36.0
    number match{
        // 1. 匹配上Square(n)后 调用unapply(number)
        // 2. 如果对象提取器返回Some(6.0)，表示匹配成功
        //    同时将6.0赋值给Square(n)的n
        //
      case Square(n) => println(n)
      case _ => println("nothing matched")
    }

    val num:Int=(3.4).toInt

    val namesString = "Alice,Bob,Thomas"
    namesString match{
      case Names(first, second, third) => {
        println(s"$first $second $third")
      }
      case _ => println("nothing matced")
    }


    // 变量声明中的模式
    val (x,y)=(1,2)
    val (q,r)=BigInt(10) /% 3
    val arr=Array(1,7,2,9)
    val Array(first,second, _*)=arr
    println(first, second)


    // for表达式中的模式
    val map=Map("A"->1, "B"->0, "C"->3)
    for((k,v) <-map) {
      println(k+"->"+v)
    }
    for((k,0) <- map){
      println(k+ "-->" +0) // B-->0
    }
    for((k,v) <- map if v==0){ // 跟上面的 含义一样
      println(k+" --->"+v) // B --->0
    }
  }
}

object Square{


  // 1. unapply是对象提取器
  // 2. 接受 z:Double   返回类型Option[Double]
  // 3. 返回值 Some(math.sqrt(z))  返回根号z 放入Some(x)
  def unapply(z:Double):Option[Double]=Some(math.sqrt(z))
  def apply(z:Double):Double=z*z
}

object Names{
  def unapplySeq(str: String): Option[Seq[String]] ={
    if(str.contains(",")) Some(str.split(","))
    else None
  }
}