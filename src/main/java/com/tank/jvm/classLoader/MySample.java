package com.tank.jvm.classLoader;

/**
 * @author tank
 * @create 2019/12/01 21:25
 */
public class MySample {
    public MySample() {
        System.out.println("MySample is loaded by: " + this.getClass().getClassLoader());

        new MyCat();

        System.out.println(MyCat.class);
    }
}
