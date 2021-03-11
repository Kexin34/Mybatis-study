package com.kexin.dao;

import com.kexin.pojo.User;
import com.kexin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);

        System.out.println(user);

        sqlSession.close();
    }
    // select * from user where id = #{id}
    // 类型处理器
    // select id,name,pwd from user where id = #{id}

}
