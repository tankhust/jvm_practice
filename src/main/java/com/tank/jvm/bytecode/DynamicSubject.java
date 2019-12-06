package com.tank.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author tank
 * @create 2019/12/06 00:11
 */
/*
    动态代理实现机制深层次分析与动态字节码生成总结
 */
public class DynamicSubject implements InvocationHandler {

    private Object object;

    public DynamicSubject(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling: " + method);

        method.invoke(this.object, args);

        System.out.println("after calling: " + method);

        return null;
    }
}
