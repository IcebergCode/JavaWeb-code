package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
* JDBC快速入门
* */
public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //1、导入驱动jar包

        //2、注册驱动
        Class.forName("com.mysql.jdbc.Driver"); // mysql 5的驱动jar包，注册的逻辑可以省略不写，即该行可以不写，但是最好写上

        //3、获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");

        //4、定义sql语句
        String sql = "update account set balance = 1000 where id = 1";   //注意：sql语句后不加分号！！

        //5、获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        //6、执行sql
        int count = stmt.executeUpdate(sql);

        //7、处理结果
        System.out.println(count);

        //8、释放资源
        stmt.close();
        conn.close();

    }
}
