package com.wzl.chapter10_patternMatching

object Match01 {

  def main(args: Array[String]): Unit = {

    val oper='#'
    val n1=20
    val n2=10
    var res=0

    oper match {
      case '+' => {
        res = n1 + n2
        println("okkkk")
      }
      case '-' => res=n1-n2
      case '*' => res=n1*n2
      case '/' => res=n1/n2
      case 1 => res=1

      //匹配不到且没有_ MatchError异常
      case _ => println("error")
    }
    println(res)


    // 守卫  匹配范围
    for(ch<-"+-3!"){
      var sign=0
      var digit=0
      ch match{
        case '+' => sign= 1
        case '-' => sign= -1
        case _ if ch.toString.equals("3") => digit =3
        case _ if ch>1110 => println("ch>10")
        case _ => sign=2
        case _ => digit= -100 // 这句话永远不会得到执行 但不报错
      }
      println(ch+" "+sign+" "+digit)
    }

    // Match Var
    val ch='V'
    ch match{
      case '+' => println("asdf")
      case mychar => println("mychar:"+mychar) //赋值给了mychar 同时进入该case
      case _ => println("___")
    }

    // match是一个表达式，可以有返回值
    val res1=ch match{
      case 'V' => ch+"hello"
//      case mychar => println("mychar:"+mychar)
      case _ => println("___")
    }
    println(res1)
  }
}
