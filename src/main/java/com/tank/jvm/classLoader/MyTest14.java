package com.tank.jvm.classLoader;

import javax.xml.transform.Source;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author tank
 * @create 2019/11/30 17:06
 */
public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        System.out.println(loader);
        String resourcesName = "com/tank/jvm/classLoader/MyTest13.class";
        Enumeration<URL> resources = loader.getResources(resourcesName);
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            System.out.println(url);
        }
        System.out.println("--------------");
        Class<?> myTest14Class = MyTest14.class;
        Class<?> stringClass = String.class;
        System.out.println(myTest14Class.getClassLoader());
    }
}
