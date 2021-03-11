package com.kexin.dao;

import com.kexin.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询所有用户
    public List<User> getUserList();

    // 根据id查询用户
    User selectUserById(int id);

    // 插入用户
    public void addUser(User user);

    // 修改用户
    int updateUser(User user);

    // 删除用户
    int deleteUser(int id);


}

