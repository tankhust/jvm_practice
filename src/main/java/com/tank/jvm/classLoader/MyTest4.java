package com.tank.jvm.classLoader;

/**
 * @author tank
 * @create 2019/11/30 11:13
 */
/*
    对数组实例来说，其类型是JVM在运行期动态生成的，表示为[Lcom.tank.jvm.classLoader.MyParent4
    这种形式。动态生成的类型，其父类型就是Object

    对于数组元素来说，JavaDoc经常将构成数组的元素成为Component，实际上就是将数组降一个维度后的类型

    助记符：
    anewarray: 表示创建一个引用类型的（如类，接口，数组）数组，并将其引用压入栈顶
    newarray: 表示创建一个原始类型的（如int，float，char等）数组，并将其引用压入栈顶
 */
public class MyTest4 {
    public static void main(String[] args) {
//        MyParent4 myParent4 = new MyParent4();
//        System.out.println("==============");
//        MyParent4 myParent4_1 = new MyParent4();
        MyParent4[] myParent4s = new MyParent4[1];//没有对class MyParent4主动使用
        System.out.println(myParent4s.getClass());

        MyParent4[][] myParent4s1 = new MyParent4[1][1];//没有对class MyParent4主动使用
        System.out.println(myParent4s.getClass());

        System.out.println(myParent4s.getClass().getSuperclass());//class java.lang.Object
        System.out.println(myParent4s1.getClass().getSuperclass());

        System.out.println("=========");

        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

        char[] chars = new char[1];
        System.out.println(chars.getClass());

        short[] shorts = new short[1];
        System.out.println(shorts.getClass());

        boolean[] booleans = new boolean[1];
        System.out.println(booleans.getClass());
    }
}
class MyParent4{
    static{
        System.out.println("MyTest4 static block");
    }
}