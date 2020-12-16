package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * account表 添加一条记录，insert语句。属于DML语句
 * */
public class JDBCDemo02 {
    public static void main(String[] args) {
        //导入驱动jar包的步骤执行一次就行了，这里就用执行了
        Statement stmt = null;  //要定义在try外面，如果在try里面，最后的finally语句访问不到该变量
        Connection conn = null; //要定义在try外面，如果在try里面，最后的finally语句访问不到该变量
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2、定义sql
            String sql = "insert into account values(null, '王五', 3000)";

            //3、获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");

            //4、获取执行sq的对象 Statement
            stmt = conn.createStatement();

            //5、执行sql
            int count = stmt.executeUpdate(sql);    //count表示sql语句影响的行数

            //6、处理结果
            System.out.println(count);
            if(count > 0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            //stmt.close();   //stmt可能执行不到，从而产生空指针异常
            //7、释放资源
            //为了避免空指针异常
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
