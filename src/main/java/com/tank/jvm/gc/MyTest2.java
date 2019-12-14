package com.tank.jvm.gc;

/**
 * @author tank
 * @create 2019/12/12 19:43
 */
/*
    -verbose:gc
    -Xms20M
    -Xmx20M
    -Xmn10M
    -XX:+PrintGCDetails
    -XX:SurvivorRatio=8
    -XX:PretenureSizeThreshold=4194304
    -XX:+UseSerialGC
 */
/*
    PretenureSizeThreshold:设置对象超过多大时直接在老年代进行分配
 */
public class MyTest2 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
//        byte[] bytes = new byte[5 * size];
        byte[] bytes = new byte[5 * size];
        try {
            Thread.sleep(1000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
