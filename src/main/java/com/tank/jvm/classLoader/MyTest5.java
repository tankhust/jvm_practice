package com.tank.jvm.classLoader;


/**
 * @author tank
 * @create 2019/11/30 11:28
 */

/**
 * 编译时能解决的，就不在运行时初始化
 */
/*
    当一个接口在初始化时，并不要求其父接口都完成了初始化
    只有在真正使用父接口（如引用父接口中所定义的变量时），才会初始化

    ！！！这里建议仔细看， 配合将MyParent5删除掉的操作得出结论
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyParent5_1.thread);
    }
}

class MyGrandPa {
    //    public static int a = 1/0;//证明是否初始化
    public static Thread thread = new Thread() {
        {
            System.out.println("MyGrandPa invoked!");
        }
    };//证明是否初始化
}

class MyParent5 extends MyGrandPa{
//    public static int a = 1/0;//证明是否初始化
    public static Thread thread = new Thread() {
        {
            System.out.println("MyParent5 invoked!");
        }
    };//证明是否初始化
}

class MyChild5 extends MyParent5 {
//    public static int b = 6;
    public static int b = 3;
}

//class MyParent5 {
//    public static final int a = new Random().nextInt(2);
//}
//
//class MyChild5 extends MyParent5 {
//    //    public static int b = 6;
//    public static final int b = 3;
//}

/*
    在初始化一个接口时，并不会初始化它的父接口
 */
interface MyGrandPa_1{
    public static Thread thread = new Thread() {
        {
            System.out.println("MyGrandPa_1 invoked!");
        }
    };//证明是否初始化
}

interface MyParent5_1 extends MyGrandPa_1{
    public static Thread thread = new Thread() {
        {
            System.out.println("MyParent5_1 invoked!");
        }
    };//证明是否初始化
}