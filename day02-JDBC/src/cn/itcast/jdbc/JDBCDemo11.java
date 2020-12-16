package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 练习：
 *      * 需求：
 *          1. 通过键盘录入用户名和密码
 *          2. 判断用户是否登陆成功
 * */
public class JDBCDemo11 {
    public static void main(String[] args) {
        //1. 键盘录入，接收用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();

        System.out.println("请输入密码：");
        String password = sc.nextLine();

        //2. 调用方法
        boolean flag = new JDBCDemo11().login2(username, password);

        //3. 判断结果，输出不同结果
        if(flag){
            //如果flag为true，登陆成功
            System.out.println("登陆成功");
        }else {
            System.out.println("用户名或密码错误");
        }
    }
    /**
     * 登陆方法，使用PreparedStatement来实现
     * */
    public boolean login2(String username, String password){
        if(username == null || password == null){
            return false;
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        //连接数据库判断是否登陆成功
        try {
            //1. 获取连接
            conn = JDBCUtils.getConnection();

            //2. 定义sql
            String sql = "select * from user where username = ? and password = ?"; //注意有单引号

            //3. 获取执行sql的对象
            pstmt = conn.prepareStatement(sql);
            //注意要给?赋值
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            //4. 执行查询语句，不需要传递sql作为参数。注意PreparedStatement的executeQuery方法 与 Statement的executeQuery方法的区别
            rs = pstmt.executeQuery();

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
            JDBCUtils.close(rs, pstmt, conn);
        }

        return false;
    }
}
