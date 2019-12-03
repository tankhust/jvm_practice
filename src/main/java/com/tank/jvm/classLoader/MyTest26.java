package com.tank.jvm.classLoader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author tank
 * @create 2019/12/03 15:23
 */
/*
    线程上下文类加载器的一般使用方法（获取-使用-还原）

    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    try{
        Thread.currentThread().setContextClassLoader(targetTccl);
        myMethod();
    }finally{
        Thread.currentThread().setContextClassLoader(classLoader);
    }

    myMethod()中则调用了Thread.currentThread().getContextClassLoader()，获取当前线程的上下文类加载器做某些事情

    如果一个类由类加载器A加载，那么这个类的依赖类也是由相同的类加载器来加载的（如果依赖类之前没有被加载过的话）

    ContextClassLoader的作用就是破坏Java的双亲委托模型

    当高层提供了接口供低层去实现，同时又要在高层加载（或实例化）低层的类时，就必须要通过线程的上下文类加载器来帮助高层的
    ClassLoader找到并加载该类

 */
public class MyTest26 {
    public static void main(String[] args) {
        //Thread.currentThread().setContextClassLoader(Thread.currentThread().getContextClassLoader().getParent());

        //BootStrap类加载器加载的ServiceLoader可以使用App类加载器加载的Drive.class
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();

        /*
            将当前线程上下文类加载器改为父加载器（即改为ext类记载器）之后,ext加载不到classpath下的配置文件，因此iterator为空
         */
        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("driver: " + driver.getClass() + ", loader: " + driver.getClass().getClassLoader());
        }

        System.out.println("当前线程上下文类加载器： " + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器： " + ServiceLoader.class.getClassLoader());
    }
}
