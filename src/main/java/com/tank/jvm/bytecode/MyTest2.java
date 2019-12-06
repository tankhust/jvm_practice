package com.tank.jvm.bytecode;

/**
 * @author tank
 * @create 2019/12/04 21:46
 */
/*
    用于javap反编译后对字节码的理解练习
 */
public class MyTest2 {
    String str = "welcome";
    private int x = 5;
    private static int in = 10;

    public static void main(String[] args) {
        MyTest2 mytest2 = new MyTest2();
        mytest2.setX(8);
        in = 20;
    }

    //    public void setX(int x) {
//        this.x = x;
//    }

    //这种synchronized锁字节码会被优化
    private synchronized void setX(int x) {
        this.x = x;
    }

    private void test(String str) {
        synchronized (str) {
            System.out.println("hello world");
        }
    }

    private static synchronized void test2() {

    }
}
