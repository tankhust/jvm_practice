package com.tank.jvm.classLoader;

/**
 * @author tank
 * @create 2019/11/30 17:25
 */
public class MyTest15 {
    public static void main(String[] args) {
        String[] strs = new String[1];
        System.out.println(strs.getClass().getClassLoader());//String类型的ClassLoader为BootStrap类加载器，用null表示
        System.out.println("---------");
        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());//非基本类型的数组的ClassLoader和这个类型的ClassLoader一致
        System.out.println("----------");
        int[] ints = new int[3];
        System.out.println(ints.getClass().getClassLoader());//基本类型的数组的CLassLoader没有（null)
    }
}
