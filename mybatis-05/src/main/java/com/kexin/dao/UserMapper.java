package com.kexin.dao;

import com.kexin.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

    // 根据id查询用户
    // 方法存在多个参数，所有的参数前面必须加上@Param("id")注解
    @Select("select * from user where id = #{id}")
    User selectUserById(@Param("id") int id);

    //添加一个用户
    @Insert("insert into user (id,name,pwd) values (#{id},#{name},#{password})")
    int addUser(User user);

    //修改一个用户
    @Update("update user set name=#{name},pwd=#{password} where id = #{id}")
    int updateUser(User user);

    //根据id删除用户
    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);
}

