package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 练习：
 *      * 需求：
 *          1. 通过键盘录入用户名和密码
 *          2. 判断用户是否登陆成功
 * */
public class JDBCDemo10 {
    public static void main(String[] args) {
        //1. 键盘录入，接收用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();

        System.out.println("请输入密码：");
        String password = sc.nextLine();

        //2. 调用方法
        boolean flag = new JDBCDemo10().login(username, password);

        //3. 判断结果，输出不同结果
        if(flag){
            //如果flag为true，登陆成功
            System.out.println("登陆成功");
        }else {
            System.out.println("用户名或密码错误");
        }
    }
    /**
     * 登陆方法
     * */
    public boolean login(String username, String password){
        if(username == null || password == null){
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        //连接数据库判断是否登陆成功
        try {
            //1. 获取连接
            conn = JDBCUtils.getConnection();

            //2. 定义sql
            String sql = "select * from user where username = '" + username + "' and password = '" + password +"'"; //注意有单引号

            //3. 获取执行sql的对象
            stmt = conn.createStatement();

            //4. 执行查询语句
            rs = stmt.executeQuery(sql);

            //5. 判断
            /*if(rs.next()){  //如果有下一行，则返回true。说明查到了
                return true;
            }else {
                return false;
            }*/
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, stmt, conn);
        }

        return false;
    }
}
