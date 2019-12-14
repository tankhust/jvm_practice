package com.tank.jvm.gc;

/**
 * @author tank
 * @create 2019/12/12 13:49
 */
/*
    -verbose:gc
    -Xms20M
    -Xmx20M
    -Xmn10M
    -XX:+PrintGCDetails
    -XX:SurvivorRatio=8
    -XX:+PrintCommandLineFlags
    -XX:MaxTenuringThreshold=5
    -XX:+PrintTenuringDistribution
 */
/*
    MaxTenuringThreshold作用：在可以自动调节对象晋升（Promote）到老年代阈值的GC中，设置该阈值的最大值。
    该参数的默认值为15，CMS张红默认值为6，G1中默认为15（在JVM中，该数值是由4个bit来表示的，所以最大值1111，即15）

    经历了多次 GC 后，存活的对象会在 From Survivor 与 To Survivor 之间来回存放，而这里面的一个前提则是这两个空间
    有足够的大小来存放这些数据，在 Gc 算法中会计算每个对象年龄的大小，如果达到某个年龄后发现总大小已经大于了 Survivor
    空间的 50%，那么这时就需要调整阈值，不能再继续等到默认的 15 次 gc 后オ完成晋升，因为这样会导致 Survivor 空间不足，
    所以需要调整阈值，让这些存活象尽快完成晋升。
 */
public class MyTest3 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[2 * size];
        byte[] myAlloc4 = new byte[2 * size];
        System.out.println("hello world");
    }
}
