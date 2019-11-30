package com.tank.jvm.classLoader;

/**
 * @author tank
 * @create 2019/11/30 10:12
 */

/**
 * 对于静态变量来说，只有直接定义了该字段的类才会被初始化
 * 一个类被初始化时，其父类必须先初始化完毕
 * -XX:+TraceClassLoading,用于追踪类的加载信息并打印出来
 * -XX:+<option>,表示开启option选项
 * -XX:-<option>,表示关闭option选项
 * -XX:<option> = <value>,表示将option选项的值设置为value
 */
public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str2);
    }
}

class MyParent1 {
    public static String str = "hello world";
    public static int i = 1 / 0;
    static{
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1{
    public static String str2 = "welcome";
    static{
        System.out.println("MyChild1 static block");
    }
}
