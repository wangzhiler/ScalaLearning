package com.wzl.chapter05_oo;

public class SuperClass {
    public static void main(String[] args) {
        //A()
        //B()
        B b = new B();

        //A(String name)jack
        //B(String name)jack
        B b2 = new B("jack");
    }
}

class A{
    public A(){
        System.out.println("A()");
    }
    public A(String name) {
        System.out.println("A(String name)"+name);
    }

}

class B extends A{
    public B(){
        // 这里会隐式调用super(), 就是无参的父类构造器
        // super()
        System.out.println("B()");
    }

    public B(String name) {
        super(name);
        System.out.println("B(String name)"+name);
    }
}
