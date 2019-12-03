package com.tank.jvm.classLoader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * @author tank
 * @create 2019/12/02 18:46
 */
public class MyTest19 {
    public static void main(String[] args) {
        AESKeyGenerator keyGenerator = new AESKeyGenerator();
        System.out.println(keyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class.getClassLoader());
    }
}
