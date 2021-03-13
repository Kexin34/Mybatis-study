package com.kexin.dao;

import com.kexin.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {


    //根据id查询用户
    User queryUserById(@Param("id") int id);

    //修改用户
    int updateUser(Map map);

}
