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

    @Test
    public void testSelectUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();  //获取SqlSession连接
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectUserById(1);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void getUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();  //获取SqlSession连接
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserLike("李");
        for (User user: userList){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testAddUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(new User(5,"哈哈","666"));

        //增删改一定要提交事务
        sqlSession.commit();

        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(4,"asdfgh","123123123" ));
        //System.out.println(i);

        //提交事务,重点!不写的话不会提交到数据库
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDeleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.deleteUser(4);
        System.out.println(i);

        //提交事务,重点!不写的话不会提交到数据库
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userid",4);
        map.put("username","王虎");
        map.put("userpassword",789);
        mapper.addUser2(map);

        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

    @Test
    public void selectUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id",1);

        User user = mapper.selectUserById2(map);
        System.out.println(user);

        //关闭资源
        sqlSession.close();
    }
}
