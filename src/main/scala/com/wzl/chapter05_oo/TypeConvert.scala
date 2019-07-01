package com.wzl.chapter05_oo

object TypeConvert {

  def main(args: Array[String]): Unit = {

    // classOf： 得到类名
    println(classOf[String])
    val s="king"
    println(s.getClass.getName) // 反射机制

    // isInstanceOf asInstanceOf
    var p1=new Person002
    var emp=new Emp2
    // 将子类引用给父类，向上转型，自动
    p1=emp
    // 将父类引用重新转成子类引用，多态
    var emp2=p1.asInstanceOf[Emp2]

    emp2.sayEmp2()


    val stu1=new Student1
    val stu2=new Student2
    test(stu1)
    test(stu2)

  }

  def test(p:Person003): Unit ={
    if(p.isInstanceOf[Student1]){
      p.asInstanceOf[Student1].showInfo()
    }else if(p.isInstanceOf[Student2]){
      p.asInstanceOf[Student2].cry()
    }else{
      println("转换失败")
    }
  }
}


class Person002{
  var name:String="tom"
  def printName(): Unit ={
    println("Person printName()"+name)
  }
  def sayHi(): Unit ={
  }
}

class Emp2 extends Person002{
  override def printName(): Unit ={
    println("Emp printName()"+name)
    super.printName()
    sayHi()
  }

  def sayEmp2(): Unit ={

  }
}

class Person003{
  def printName(): Unit ={
    println("Person003 printName")
  }
  def sayOk(): Unit ={
    println("Person003 sayOk")
  }
}

class Student1 extends Person003{
  val stuId=100

  override def printName(): Unit = {
    println("Student1 printName")
  }

  def showInfo(): Unit ={
    println("学生id："+stuId)
  }
}

class Student2 extends Person003{
  val stuId=200

  override def printName(): Unit = {
    println("Student2 printName")
  }

  def cry(): Unit ={
    println("cry："+stuId)
  }
}