package com.wzl.chapter06_ooAdvance

object Accompany {
  def main(args: Array[String]): Unit = {

//    println(ScalaPerson.sex) // 等价于ScalaPerson$.MODULE$.sex()
//    ScalaPerson.sayHi() // 等价于ScalaPerson$.MODULE$.sayHi()

    val child1=new Child("a")
    val child2=new Child("b")
    val child3=new Child("c")

    Child.joinGame(child1)
    Child.joinGame(child2)
    Child.joinGame(child3)

    Child.showNum()

    // Apply
    // 当伴生对象中定义apply方法，可以实现类名（参数名）方式来创建对象实例
    val list=List(1,2,5)
    println(list)

    val pig=new Pig("aaa")
    // 使用pig的apply方法创建对象
    val pig2=Pig("bbb")
    val pig3=Pig()
    println(pig2.name+" "+pig3.name)

  }
}

// 1. 当存在class object 名字相同
//    class 为伴生类，非静态对象
//    object 为伴生对象，静态对象
// 2. class ScalaPerson底层编译后会生成 ScalaPerson.class
//    object ScalaPerson底层编译后会生成 ScalaPerson$.class
// 3. 伴生对象的属性方法可以直接调用

// 伴生类
class ScalaPerson{
  var name:String=_
}

// 伴生对象
object ScalaPerson{
  var sex:Boolean=true
  def sayHi(): Unit ={
    println("hi")
  }
}

class Child(cName:String){
  var name=cName
}

object Child{
  var totalChildNum=0

  def joinGame(child:Child): Unit ={
    printf("%s 小孩加入了游戏\n", child.name)
    totalChildNum+=1
  }
  def showNum(): Unit ={
    printf("当前%d小孩在玩游戏\n", totalChildNum)
  }
}

// apply
class Pig(pName:String){
  var name:String=pName
}

object Pig{
  // apply()
  def apply(pName: String): Pig = new Pig(pName)

  def apply():Pig=new Pig("匿名猪猪")
}

