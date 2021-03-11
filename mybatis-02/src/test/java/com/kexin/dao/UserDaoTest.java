package com.kexin.dao;

import com.kexin.pojo.User;
import com.kexin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    @Test
    public void test() {

        // 第一步：获得 sqlSession 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 第二步：执行 SQL
        // 方式一： getMapper (推荐使用该方式)
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        // 方式二 (不推荐使用该方式，过时)
//        List<User> userList = sqlSession.selectList("com.kexin.dao.UserDao.getUserList");

        for (User user : userList) {
            System.out.println(user);
        }

        // 关闭 sqlSession
        sqlSession.close();

    }

}
