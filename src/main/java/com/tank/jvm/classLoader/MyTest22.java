package com.tank.jvm.classLoader;

/**
 * @author tank
 * @create 2019/12/02 19:38
 */
/*
    修改扩展类加载器ext的加载路径执行： java -Djava.ext.dirs=./ com.tank.jvm.classLoader.MyTest22
    由于扩展类加载器只能加载jar包，故先将MyTest1打成jar包：jar -cvf test.jar com/tank/jvm/classLoader/MyTest1.class
 */
public class MyTest22 {
    static{
        System.out.println("MyTest22 Initializer");
    }

    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());
        System.out.println(MyTest1.class.getClassLoader());
    }
}
