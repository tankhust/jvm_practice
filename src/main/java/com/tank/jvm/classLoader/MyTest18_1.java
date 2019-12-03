package com.tank.jvm.classLoader;

/**
 * @author tank
 * @create 2019/12/02 18:42
 */
public class MyTest18_1 {
    public static void main(String[] args) throws ClassNotFoundException {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("Users/tank/Desktop/");
        Class<?> clazz = loader1.loadClass("com.tank.jvm.classLoader.MyTest1");

        System.out.println("clazz: " + clazz.hashCode());
        System.out.println("clazz classLoader: " + clazz.getClassLoader());
    }
}
