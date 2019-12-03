package com.tank.jvm.classLoader;

import javax.xml.transform.Source;
import java.io.*;

/**
 * 自定义类加载器
 * @author tank
 * @create 2019/11/30 17:36
 */
public class MyTest16 extends ClassLoader{
    private String classLoaderName;
    private String path;
    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName) {
        super();// 将系统类加载器当做该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);// 显示指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    /*
        为了迎合 -Djava.system.class.loader指定为MyTest需要一个指定ClassLoader的构造函数 的要求
     */
    public MyTest16(ClassLoader parent) {
        super(parent);
    }

    public void setPath(String path) {
        this.path = path;
    }

//    @Override
//    public String toString() {
//        return "[" + this.classLoaderName +"]";
//    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("findClass invoked: " + className);
        System.out.println("class loader name: " + this.classLoaderName);
        byte[] data = this.loadClassData(className);

        return this.defineClass(className,data,0,data.length);
    }

    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
//            this.classLoaderName = this.classLoaderName.replace(".", "/");
            className = className.replace(".", "/");
            is = new FileInputStream(new File(this.path + className + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                baos.close();
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/tank/Desktop/");

        Class<?> clazz = loader1.loadClass("com.tank.jvm.classLoader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println("ClassLoader: " + object.getClass().getClassLoader());

        System.out.println();

        loader1 = null;
        clazz = null;
        object = null;
        System.gc();// 必须先设置VM参数 -XX:+TraceClassUnloading

        Thread.sleep(100000);// 使用jvisualvm工具查看卸载时的类的状态

        loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/tank/Desktop/");

        clazz = loader1.loadClass("com.tank.jvm.classLoader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        object = clazz.newInstance();
        System.out.println(object);
        System.out.println("ClassLoader: " + object.getClass().getClassLoader());


//        MyTest16 loader2 = new MyTest16(loader1,"loader2");
//        loader2.setPath("/Users/tank/Desktop/");
//
//        Class<?> clazz2 = loader2.loadClass("com.tank.jvm.classLoader.MyTest1");
//        System.out.println("class: " + clazz2.hashCode());
//        Object object2 = clazz.newInstance();
//        System.out.println(object2);
//        System.out.println("ClassLoader: " + object2.getClass().getClassLoader());
//
//        MyTest16 loader3 = new MyTest16("loader3");
//        loader3.setPath("/Users/tank/Desktop/");
//
//        Class<?> clazz3 = loader3.loadClass("com.tank.jvm.classLoader.MyTest1");
//        System.out.println("class: " + clazz3.hashCode());
//        Object object3  = clazz.newInstance();
//        System.out.println(object3);
//        System.out.println("ClassLoader: " + object3.getClass().getClassLoader());
    }

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("com.tank.jvm.classLoader.MyTest1");
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());
    }
}
