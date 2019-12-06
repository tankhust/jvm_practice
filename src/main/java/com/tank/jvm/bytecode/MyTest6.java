package com.tank.jvm.bytecode;

/**
 * @author tank
 * @create 2019/12/05 22:38
 */
/*
    方法的动态分派

    方法的动态分派涉及到一个重要的概念：方法接受者。

    invokevirtual字节码指令的多态查找流程

    比较方法重载（Overload)和方法重写（Override），我们可以得到一个这样的结论

    方法重载是静态的，是编译期行为；方法重写是动态的，是运行期行为。
 */
public class MyTest6 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }

}

class Fruit {
    public void test() {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {
    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Apple {
    @Override
    public void test() {
        System.out.println("Orange");
    }
}
