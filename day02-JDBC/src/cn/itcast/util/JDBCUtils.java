package cn.itcast.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 * */
public class JDBCUtils {
    private static String url;  //加static原因：只有静态的变量才能被静态代码块访问，才能被静态的方法访问
    private static String user;
    private static String password;
    private static String driver;
    /**
     * 文件的读取，只需要读取一次即可拿到这些值。使用静态代码块
     * */
    static {
        //读取资源文件，获取值
        try {
            //1. 创建Properties集合类
            Properties pro = new Properties();

            //获取src路径下的文件方式--->ClassLoader类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            //以scr为相对路径，getResource方法中传递"jdbc.properties"即可。
            URL res = classLoader.getResource("jdbc.properties");//返回的URL对象表示同一资源定位符，它可以定位一个文件的绝对路径
            String path = res.getPath();    //获取字符串路径
            //System.out.println(path);

            //2. 加载文件
            //pro.load(new FileReader("day02-JDBC\\src\\jdbc.properties"));   //写绝对路径没有问题，但是不合适
            pro.load(new FileReader(path));

            //3. 获取属性，赋值
            JDBCUtils.url = pro.getProperty("url");   //传递进去的键的名称，要和配置文件中的名称一样
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            //4. 注册驱动
            Class.forName(driver);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接
     * @return 连接对象
     * */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     * */
    public static void close(Statement stmt, Connection conn){
        if(stmt != null){       //先释放小的，再释放大的
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
    * 释放资源
    * @param rs
    * @param stmt
    * @param conn
    * */
    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
