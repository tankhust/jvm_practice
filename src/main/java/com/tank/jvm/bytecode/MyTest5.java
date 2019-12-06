package com.tank.jvm.bytecode;

/**
 * @author tank
 * @create 2019/12/05 22:25
 */
/*
    方法的静态分派

    Grandpa g1 = new Father();

    以上代码,g1的静态类型是Grandpa，而g1的实际类型（真正指向的类型）是Father

    我们可以得到这样一个结论：变量的静态类型是不会变化的，而类型的实际变量是可以变化的（多态的一种表现），
    实际类型是在运行期间方可确定。


 */
public class MyTest5 {
    //方法重载，是一种静态行为，编译器就可以确定。
    public void test(Grandpa grandpa) {
        System.out.println("grandpa");
    }

    public void test(Father father) {
        System.out.println("father");

    }

    public void test(Son son) {
        System.out.println("son");

    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        MyTest5 myTest5 = new MyTest5();

        myTest5.test(g1);
        myTest5.test(g2);
    }
}

class Grandpa {

}

class Father extends Grandpa {
}

class Son extends Father {
}