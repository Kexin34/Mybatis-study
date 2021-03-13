import com.kexin.dao.UserMapper;
import com.kexin.pojo.User;
import com.kexin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;

public class MyTest {
    @Test
    public void testQueryUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);
        System.out.println(user == user2);

        sqlSession.close();
    }

    @Test
    public void testQueryUserById2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        HashMap map = new HashMap();
        map.put("name","kuangshen");
        map.put("id",4);
        mapper.updateUser(map);

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user == user2);

        sqlSession.close();
    }

    @Test
    public void testQueryUserById3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        sqlSession.clearCache();//手动清除缓存

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);
        System.out.println(user == user2);

        sqlSession.close();
    }

    @Test
    public void testQueryUserById_SecondLevel() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();

        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user == user2);

        sqlSession2.close();
    }
}

