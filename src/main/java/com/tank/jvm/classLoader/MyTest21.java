package com.tank.jvm.classLoader;

import java.lang.reflect.Method;

/**
 * @author tank
 * @create 2019/12/02 19:06
 */
/*
    类加载器的双亲委托模型的好处：
    1.  可以确保Java核心库的类型安全。所有的Java应用都至少会引用java.lang.Object类，也就是说在运行期，java.lang.Object
        这个类会被加载到Java虚拟机中；如果这个加载过程是由Java应用自己的类加载器完成的，那么很有可能在JVM中存在多个版本的
        java.lang.Object类，而这些类时相互不兼容，互不可见的（正是命名空间发挥了作用）
        借助双亲委托机制，Java核心类库中的类的加载工作是由启动类加载器来统一完成，从而确保了Java应用所使用的都是同一个版本的Java
        核心类库，他们之间都是相互兼容的。
    2.  可以确保Java核心类库所提供的类不会被自定义的类所替代
    3.  不同类加载器可以为相同名称（binary name）的类创建额外的命名空间。相同名称的类可以在Java虚拟机中，只需要用不同
        的类加载器加载他们即可。不同的类加载器加载的类之间是不兼容的，这相当于在Java虚拟机内部创建了一个又一个相互隔离的
        Java类空间，这类技术在很多框架中都得到了实际应用。
 */
public class MyTest21 {
    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");
        loader1.setPath("/Users/tank/Desktop/");
        loader2.setPath("/Users/tank/Desktop/");

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
