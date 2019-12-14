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
 */
/*
    PSYoungGen:新生代垃圾回收器（Parallel Scavenge 新生代垃圾收集器）
    ParOldGen:Parallel Old(老年代垃圾收集器)
 */
public class MyTest1 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
//        byte[] myAlloc1 = new byte[2 * size];
//        byte[] myAlloc2 = new byte[2 * size];
//        byte[] myAlloc3 = new byte[2 * size];
//        byte[] myAlloc4 = new byte[2 * size];

        /*
            运行后Console打印结果如下：
            [GC ... 为 -verbose:gc配置打印的信息
            hello world为程序输出
            Heap... 为 -XX:+PrintGCDetails配置打印的信息
            5834K->672K(9216K)//执行gc后，新生代释放的空间容量为5834-624=5022k
            5834K->4776K(19456K)//执行gc后，总的堆空间释放的容量为5834k-4776=918k

            5022-918=4104k为ParOldGen老年代使用的空间容量



            [GC (Allocation Failure) [PSYoungGen: 5834K->672K(9216K)] 5834K->4776K(19456K), 0.0027017 secs] [Times: user=0.03 sys=0.00, real=0.00 secs]
            hello world
            Heap
             PSYoungGen      total 9216K, used 4065K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
              eden space 8192K, 41% used [0x00000007bf600000,0x00000007bf950438,0x00000007bfe00000)
              from space 1024K, 65% used [0x00000007bfe00000,0x00000007bfea8000,0x00000007bff00000)
              to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
             ParOldGen       total 10240K, used 4104K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
              object space 10240K, 40% used [0x00000007bec00000,0x00000007bf002020,0x00000007bf600000)
             Metaspace       used 2956K, capacity 4496K, committed 4864K, reserved 1056768K
              class space    used 323K, capacity 388K, committed 512K, reserved 1048576K
         */
        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[3 * size];
        System.out.println("hello world");
    }
}
