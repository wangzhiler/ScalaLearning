package com.wzl.chapter10_patternMatching

object Goods {

  /*

  有一些商品，设计样例类，完成商品捆绑打折出售。
  1. 商品捆绑可以单个，可以多个
  2. 打折时按照折扣x元进行设计
  3. 统计所有捆绑商品打折后的最终价格

   */
  def main(args: Array[String]): Unit = {


    val sale=Bundle("书籍", 10, Book("漫画", 40),
      Bundle("文学作品",20, Book("《阳关》",80), Book("《围城》",30)))

    val res=sale match{
      // 1. 得到 “漫画”
      case Bundle(_,_,Book(desc,_), _*) => desc
    }
    println(res)

    // 2. @可以将嵌套的值绑定到变量
    val res1=sale match{
      case Bundle(_,_,art @ Book(_,_), rest @ _*) => (art,rest)
      // (Book(漫画,40.0),WrappedArray(Bundle(文学作品,20.0,
      // WrappedArray(Book(《阳关》,80.0), Book(《围城》,30.0)))))
    }
    println(res1)

    // 3. 不适用_*绑定剩余Item到rest
    val res2=sale match{
      case Bundle(_,_, art2 @ Book(desc,_), rest2) => (art2, rest2)
      // (Book(漫画,40.0),Bundle(文学作品,20.0,
      // WrappedArray(Book(《阳关》,80.0), Book(《围城》,30.0))))
    }
    println(res2)


    // 4. 完成案例
    def price(it: Item):Double={
      it match{
        case Book(_,p) => p
        // 生成一个新的集合， _是将its中每个循环的元素传递到price的it中
        case Bundle(_, disc, its @ _*) => its.map(price _).sum - disc
      }
    }

    println(price(sale))

  }
}


abstract class Item

case class Book(description: String, price:Double) extends Item
case class Food(description: String, price:Double) extends Item
case class Bundle(description: String, discount:Double, Item:Item*) extends Item
