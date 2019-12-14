package com.tank.jvm.g1;

/**
 * @author tank
 * @create 2019/12/14 11:56
 */
/*
    -verbose:gc
    -Xms10m
    -Xmx10m
    -XX:+UseG1GC
    -XX:+PrintGCDetails
    -XX:+PrintGCTimeStamps
    -XX:MaxGCPauseMillis=200m
 */
public class MyTest1 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] myAlloc1 = new byte[size];
        byte[] myAlloc2 = new byte[size];
        byte[] myAlloc3 = new byte[size];
        byte[] myAlloc4 = new byte[size];
        System.out.println("hello world");
    }
}
