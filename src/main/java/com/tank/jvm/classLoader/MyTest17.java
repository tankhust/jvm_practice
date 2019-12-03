package com.tank.jvm.classLoader;

/**
 * @author tank
 * @create 2019/12/01 21:26
 */
public class MyTest17 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/tank/Desktop/");

        Class<?> clazz = loader1.loadClass("com.tank.jvm.classLoader.MySample");
        System.out.println(clazz.hashCode());

        /**
         *  如果注释掉该行，那么就不会实例化MySample对象，即MySample对象不会被实例化
         *  因此MyCat对象不会被实例化，即没有对MyCat对象主动使用，这里就不会加载MyCat Class
         */
        Object object = clazz.newInstance();
    }
}
