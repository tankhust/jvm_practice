package com.tank.jvm.classLoader;

/**
 * @author tank
 * @create 2019/11/30 17:04
 */
public class MyTest13 {
    public static void main(String[] args) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);
        while (null != loader) {
            loader = loader.getParent();
            System.out.println(loader);
        }
    }
}
