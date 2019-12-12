package com.tank.jvm.memory;

/**
 * @author tank
 * @create 2019/12/11 19:20
 */
/*
    死锁 用jconsole和jvisualvm检测
 */
public class MyTest3 {
    public static void main(String[] args) {
//        MyTest3 myTest3 = new MyTest3();
//        A a = new A();
//        B b = new B();
//        a.method();
//        b.method();
        new Thread(() -> A.method(),"Thread-A").start();
        new Thread(() -> B.method(),"Thread-B").start();
        try {
            Thread.sleep(40000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class A{

    public static synchronized void method() {
        System.out.println("method from A");
        try {
            Thread.sleep(5000);
            B.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class B{

    public static synchronized void method() {
        System.out.println("method from B");
        try {
            Thread.sleep(5000);
            A.method();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}