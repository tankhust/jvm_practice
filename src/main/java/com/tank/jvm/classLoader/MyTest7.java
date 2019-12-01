package com.tank.jvm.classLoader;

/**
 * @author tank
 * @create 2019/11/30 16:22
 */
public class MyTest7 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazz1 = Class.forName("com.tank.jvm.classLoader.C");
        System.out.println(clazz1.getClassLoader());

    }
}
class C {

}
