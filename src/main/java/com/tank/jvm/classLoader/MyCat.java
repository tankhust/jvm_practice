package com.tank.jvm.classLoader;

/**
 * @author tank
 * @create 2019/12/01 21:24
 */
public class MyCat {
    public MyCat() {
        System.out.println("MyCat is loaded by: " + this.getClass().getClassLoader());
        //System.out.println("from MyCat: " + MySample.class);
    }
}
