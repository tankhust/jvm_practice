package com.tank.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author tank
 * @create 2019/12/06 00:12
 */
public class Client {
    public static void main(String[] args) {
        //将生成的代理类保存
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        RealSubject rs = new RealSubject();
        InvocationHandler ds = new DynamicSubject(rs);

        Class<?> cls = rs.getClass();
        //生成代理类的字节码文件
        Subject subject = (Subject)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);

        subject.request();
        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());

    }
}
