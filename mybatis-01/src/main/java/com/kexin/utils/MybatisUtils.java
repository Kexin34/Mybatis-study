package com.kexin.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

// 工厂模式：sqlSessionFactory --> sqlSession
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {   // 用static：一初始就去加载
        try {
            //官方文档使用Mybatis第一步 ：获取sqlSessionFactory对象
            // 1. 去读mybatis-config.xml文件
            String resource = "mybatis-config.xml";
            // 2. 用流把这个文件加载进来
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 3. 通过builder把这个流加载进来
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例.
    // SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。
    // 第二步：返回能执行的sql对象
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
