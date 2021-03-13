package com.kexin.dao;

import com.kexin.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    //新增一个博客
    int addBlog(Blog blog);

    //需求1: 根据作者名字和博客名字来查询博客！如果作者名字为空，那么只根据博客名字查询，反之，则根据作者名来查询
    List<Blog> queryBlogIf(Map map);

    List<Blog> queryBlogChoose(Map map);

    // 更新博客
    int updateBlog(Map map);

    // 查询第1-2-3号记录的博客
    List<Blog> queryBlogForeach(Map map);

}
