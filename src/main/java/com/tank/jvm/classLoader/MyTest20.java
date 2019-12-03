package com.tank.jvm.classLoader;

import java.lang.reflect.Method;

/**
 * @author tank
 * @create 2019/12/02 18:52
 */
public class MyTest20 {
    public static void main(String[] args) throws Exception{

        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        Class<?> clazz1 = loader1.loadClass("com.tank.jvm.classLoader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.tank.jvm.classLoader.MyPerson");

        //不同的类加载器实例委托给了同一个应用类加载器，因此加载的class文件一致
        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);
    }
}
