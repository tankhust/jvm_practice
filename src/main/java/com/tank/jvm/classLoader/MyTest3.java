package com.tank.jvm.classLoader;

import java.util.UUID;

/**
 * @author tank
 * @create 2019/11/30 10:26
 */

/**
 * 当一个常量的值并非编译期间可以确定的，其值就不会放到调用类的常量池中
 * 这时在程序运行时，会主动调用这个常量所在的类，显然会初始化这个类
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3 {
    public static final String str = UUID.randomUUID().toString();

    static{
        System.out.println("MyParent2 static code");
    }
}
