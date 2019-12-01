package com.tank.jvm.classLoader;

/**
 * @author tank
 * @create 2019/11/30 16:51
 */
/*
    调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
 */
class CL{
    static {
        System.out.println("Class CL");
    }
}
public class MyTest12 {
    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("com.tank.jvm.classLoader.CL");//不会初始化
        System.out.println(clazz);
        System.out.println("----------------");
        clazz = Class.forName("com.tank.jvm.classLoader.CL");//会初始化
        System.out.println(clazz);
    }
}
