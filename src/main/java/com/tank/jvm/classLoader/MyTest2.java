package com.tank.jvm.classLoader;

/**
 * @author tank
 * @create 2019/11/30 10:26
 */

/**
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中，
 * 本质上，调用类没有直接引用到定义常量的类，因此并不会触发
 * 定义常量的类的初始化
 * 注意：这里指的是将常量存到了MyTest2的常量池中，之后MyTest2和MyParent2就再也没有关系了
 * 甚至，我们可以将MyTest2的class文件删除
 */

/**
 * 助记符：
 * ldc将int，float或是string类型的常量值从常量池中推送至栈顶
 * bipush表示将单字节（-128~127）的常量值推送至栈顶
 * sipush表示将短整型常量值（-32768~32767）推送至栈顶
 * iconst_1表示将int类型1推送至栈顶（iconst_0 ~ iconst_5,iconst_m1）
 *
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.m);
    }
}
class MyParent2 {
    public static final String str = "hello world";
//    public static final String str = null;
    public static final short s = 127;
    public static final int i = 128;
    public static final int m = 1;

    static{
        System.out.println("MyParent2 static block");
    }
}
