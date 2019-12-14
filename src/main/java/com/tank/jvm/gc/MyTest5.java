package com.tank.jvm.gc;

/**
 * @author tank
 * @create 2019/12/12 21:40
 */
/*
    -verbose:gc
    -Xms20M
    -Xmx20M
    -Xmn10M
    -XX:+PrintGCDetails
    -XX:SurvivorRatio=8
    -XX:+UseConcMarkSweepGC
 */
public class MyTest5 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] myAlloc1 = new byte[4 * size];
        System.out.println("111111");


        byte[] myAlloc2 = new byte[4 * size];
        System.out.println("222222");

        byte[] myAlloc3 = new byte[4 * size];
        System.out.println("333333");

        byte[] myAlloc4 = new byte[2 * size];
        System.out.println("444444");

        System.out.println("hello world");
    }
}
