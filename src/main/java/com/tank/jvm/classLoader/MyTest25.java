package com.tank.jvm.classLoader;

/**
 * @author tank
 * @create 2019/12/03 15:18
 */
public class MyTest25 implements  Runnable{
    private Thread thread;
    @Override
    public void run() {
        ClassLoader classLoader = this.thread.getContextClassLoader();
        this.thread.setContextClassLoader(classLoader);
        System.out.println("Class: " + classLoader.getClass());
        System.out.println("Parent: " + classLoader.getParent().getClass());
    }

    public MyTest25() {
        this.thread = new Thread(this);
        this.thread.start();
    }

    public static void main(String[] args) {
        new MyTest25();
    }
}
