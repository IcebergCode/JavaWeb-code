package cn.itcast.service;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/**
* 用户管理的业务接口
* */
public interface UserService {
    /**
     * 查询所有用户信息
     * */
    public List<User> findAll();
    User login(User user);

    /**
    * 保存User
    * */
    void addUser(User user);

    /**
     * 根据id删除user
     * */
    void deleteUser(String id);

    /**
     * 根据id查询
     * */
    User findUserByID(String id);

    /**
     * 修改用户信息
     * */
    void updateUser(User user);

    /**
     * 批量删除用户
     * */
    void delSelectedUser(String[] ids);

    /**
     * 分页条件查询
     * */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
