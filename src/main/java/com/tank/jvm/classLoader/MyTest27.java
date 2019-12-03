package com.tank.jvm.classLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author tank
 * @create 2019/12/03 20:43
 */
/*
    通过JDBC驱动加载深刻理解上下文类加载器机制
 */
public class MyTest27 {
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("jdbc.drivers"));
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytestdb", "username", "password");
    }
}
