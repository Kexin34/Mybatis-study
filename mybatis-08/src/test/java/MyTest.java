import com.kexin.dao.BlogMapper;
import com.kexin.pojo.Blog;
import com.kexin.utils.IDUtil;
import com.kexin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void addInitBlog() {
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtil.genId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.close();
    }

    @Test
    public void queryBlogIf() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
//        map.put("title", "Java如此简单");
        map.put("author", "狂神说");
        List<Blog> blogList = mapper.queryBlogIf(map);

        for (Blog blog: blogList){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void testQueryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap <String, Object> map= new HashMap<String, Object>();
        map.put("title", "Java如此简单");
//        map.put("author", "狂神说");
        map.put("views",9999);
        List<Blog> blogList = mapper.queryBlogIf(map);

        for (Blog blog: blogList){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void testUpdateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map= new HashMap();
        map.put("title", "动态SQL");
        map.put("author", "Kexin");
        map.put("id","63ff25e3dd2d4dab8dc14b73f684a861");

        mapper.updateBlog(map);

        sqlSession.close();
    }

    @Test
    public void testQueryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map= new HashMap();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids",ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);

        System.out.println(blogs);

        sqlSession.close();
    }
}
