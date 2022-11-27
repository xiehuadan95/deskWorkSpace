package com.xie.dao;

import com.xie.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);
    //查询博客
    List<Blog> queryBlogIf(Map map);

    //
    List<Blog> queryBlogChoose(Map map);
    //更新
    int updateBlog(Map map);
    //查询第1 2 3好记录的博客
    List<Blog> queryBlogForeach(Map map);

}
