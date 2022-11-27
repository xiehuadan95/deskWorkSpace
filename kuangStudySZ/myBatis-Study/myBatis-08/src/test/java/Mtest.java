import com.xie.dao.BlogMapper;
import com.xie.pojo.Blog;
import com.xie.utils.IDUtils;
import com.xie.utils.MybatisUtils;
import lombok.experimental.Accessors;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Mtest {
    @Test
    public void addBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog=new Blog();
        blog.setId(IDUtils.getUUID());
        blog.setTitle("Mybatis动态SQL");
        blog.setCreateTime(new Date());
        blog.setAuthor("ERIC");
        blog.setViews(666);
        mapper.addBlog(blog);

        blog.setId(IDUtils.getUUID());
        blog.setTitle("java666");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getUUID());
        blog.setTitle("Spring666");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getUUID());
        blog.setTitle("微服务666");
        mapper.addBlog(blog);

        sqlSession.close();

    }
    @Test
    public void querryBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
       // map.put("title", "java666");
        //map.put("author", "jack");
        //map.put("views", "999");
       // map.put("id","94ef522eb1e44732b1d0d1f0208273f2");
       // mapper.updateBlog(map);
        List<Blog> blogs = mapper.queryBlogIf(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        map.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();

    }
}
