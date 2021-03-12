import com.kexin.dao.UserMapper;
import com.kexin.pojo.User;
import com.kexin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 底层主要应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();

        for (User user: users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testAddUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(6, "秦疆", "123456");
        mapper.addUser(user);

        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(6, "秦疆", "zxcvbn");
        mapper.updateUser(user);

        sqlSession.close();
    }

    @Test
    public void testDeleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(6);

        sqlSession.close();
    }

}
