package com.tank.jvm.bytecode;

/**
 * @author tank
 * @create 2019/12/06 00:09
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("From real subject");
    }
}
