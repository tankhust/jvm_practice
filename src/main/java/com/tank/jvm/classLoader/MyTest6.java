package com.tank.jvm.classLoader;

/**
 * @author tank
 * @create 2019/11/30 13:56
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1: " + Singleton.counter1);
        System.out.println("counter1: " + Singleton.counter2);
    }
}
//class Singleton{
//    public static int counter1;
//
//    public static int counter2 = 0;
//
//    private static Singleton singleton = new Singleton();
//
//    private Singleton(){
//        counter1++;
//        counter2++;
//    }
//
//    public static Singleton getInstance() {
//        return singleton;
//    }
//}

class Singleton{
    public static int counter1 = 1;


    private static Singleton singleton = new Singleton();
    private Singleton(){
        counter1++;
        counter2++;//准备阶段的重要意义，准备好久可以直接用了，赋了个默认值，后面再进行初始化
        System.out.println(counter1);
        System.out.println(counter2);
    }

    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}