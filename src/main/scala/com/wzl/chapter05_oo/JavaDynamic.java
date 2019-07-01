package com.wzl.chapter05_oo;

public class JavaDynamic {

    // 将一个子类的对象地址，交给了一个AA（父类）的引用
    // java 动态绑定机制
    // 1. 如果调用的是方法，则JVM会将该方法和对象的内存地址绑定
    // 2. 如果调用的是一个属性，则没有动态绑定机制，在哪里调用，就返回对应值
    public static void main(String[] args) {
        A2 obj = new B2();
        System.out.println(obj.sum()); //40  // 30
        System.out.println(obj.sum1()); //30  // 20
    }
}

class A2{
    public int i = 10;
    public int sum(){
        return getI() + 10;
    }
    public int sum1(){
        return i + 10;
    }
    public int getI(){
        return i;
    }
}

class B2 extends A2{
    public int i = 20;
//    public int sum(){
//        return i + 20;
//    }
    public int getI(){
        return i;
    }
//    public int sum1() {
//        return i + 10;
//    }
}
