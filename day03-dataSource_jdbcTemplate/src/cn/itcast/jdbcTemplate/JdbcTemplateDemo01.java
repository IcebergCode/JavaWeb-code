package cn.itcast.jdbcTemplate;

import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate入门
 * */
public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        //1. 导入jar包

        //2. 创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());     //ctrl + p：查看传入的参数

        //3. 调用方法
        String sql = "update account set balance = 5000 where id = ?";
        int count = template.update(sql, 3);
        System.out.println(count);


    }
}
