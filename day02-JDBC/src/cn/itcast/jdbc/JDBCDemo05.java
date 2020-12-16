package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 创建一张student表。属于DDL语句
 * */
public class JDBCDemo05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2、获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");

            //3、定义sql
            String sql = "create table student (id int, name varchar(20))";

            //4、获取执行sql对象
            stmt = conn.createStatement();

            //5、执行sql
            int count = stmt.executeUpdate(sql);    //DDL语句的创建表也可以使用executeUpdate语句

            //6、处理结果
            System.out.println(count);  //返回一个0

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //7、释放资源
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
}
