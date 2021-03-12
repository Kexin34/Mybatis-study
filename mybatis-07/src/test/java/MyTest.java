import com.kexin.dao.TeacherMapper;
import com.kexin.pojo.Teacher;
import com.kexin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper((TeacherMapper.class));

        List<Teacher> teacherList = mapper.getTeacher();
        for (Teacher teacher: teacherList){
            System.out.println(teacher);
        }

        sqlSession.close();
    }
    @Test
    public void testGetTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher1(1);
        System.out.println(teacher);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());

        sqlSession.close();
    }

    @Test
    public void testGetTeacher2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher3(1);

        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());

        sqlSession.close();
    }


}
