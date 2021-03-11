package com.kexin.dao;

import com.kexin.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询所有用户
    public List<User> getUserList();

    // 模糊查询
    List<User> getUserLike(String value);

    // 根据id查询用户
    User selectUserById(int id);

    // map，根据id查询用户
    User selectUserById2(Map<String,Object> map);

    // 插入用户
    public void addUser(User user);

    //用万能Map插入用户
    public void addUser2(Map<String,Object> map);

    // 修改用户
    int updateUser(User user);

    // 删除用户
    int deleteUser(int id);


}

