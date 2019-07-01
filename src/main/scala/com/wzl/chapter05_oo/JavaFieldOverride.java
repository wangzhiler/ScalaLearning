package com.wzl.chapter05_oo;

public class JavaFieldOverride {
    // Java中不能重写字段，但能隐藏父类字段
    // 如何访问隐藏字段？
    // 1. 采用父类的引用类型，如Super2 c2=new Sub2() 可以访问Super2被隐藏的s
    // 2. 将子类强制转换为父类类型
    public static void main(String[] args) {
        // 创建两个对象
        Sub2 c1 = new Sub2();
        System.out.println(c1.s); // Sub
        System.out.println(((Super2)c1).s); // Super

        Super2 c2 = new Sub2();
        System.out.println(c2.s); // Super
    }
}

class Super2{
    String s = "super";
}

class Sub2 extends Super2{
    String s = "sub";
}
