package mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import mybatisplus.entity.Product;
import mybatisplus.entity.User;
import mybatisplus.mapper.ProductMapper;
import mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
@SpringBootTest
public class IntercepterTest {
    @Resource
    private UserMapper userMapper;
    @Resource
    private ProductMapper productMapper;
    @Test
    public void test1(){
        //新建分页参数对象 查询第几页，每页5条记录
        Page<User> userPage = new Page<>(2, 5);
        //这两个对象是一个对象 参数为页对象 及qureyMapper条件构造器 先传null
        //Page<User> userPage1 = userMapper.selectPage(userPage, null);
        //System.out.println("确认是否是一个对象"+(userPage==userPage1)); true
        //优化为
        userMapper.selectPage(userPage, null);
        //当前页码下的所有记录
        List<User> users = userPage.getRecords();
        users.forEach(System.out::println);
        //总数
        long total = userPage.getTotal();
        System.out.println("总数+"+total);
        //有没有下一页
        boolean bn = userPage.hasNext();
        System.out.println("下一页？？"+bn);
        //有没有上一页
        boolean bp = userPage.hasPrevious();
        System.out.println("上一页？"+bp);

    }
    @Test
    public void selectByAge(){
        Page<User> userPage = new Page<>(2,6);
        List<User> users = userMapper.selectPageVo(userPage, 18).getRecords();
        users.forEach(System.out::println);
    }
    @Test
    public void testConcurrentUpdate() {
//小李取数据
        Product p1 = productMapper.selectById(1L);
        //小王取数据
        Product p2 = productMapper.selectById(1L);
        //小李修改+50
        p1.setPrice(p1.getPrice()+50);
        int res = productMapper.updateById(p1);
        System.out.println("小李修改数据结果为："+res);
        //小王修改数据-30
        p2.setPrice(p2.getPrice()-30);
        int res2 = productMapper.updateById(p2);
        System.out.println("小王修改数据结果为："+res2);
        //如果小王修改失败，则进行重试
        if(res2==0){
            //重新获取数据
            Product pw = productMapper.selectById(1L);
            //修改
            pw.setPrice(pw.getPrice()-30);
            int i=0;
            try {
                i = productMapper.updateById(pw);
            } catch (Exception e) {
               log.error("小王重试修改数据库失败：",e.getClass().getSimpleName());
            }
            System.out.println("小王再次重试修改数据条数："+i);
        }
        //老板看数据
        Product p3 = productMapper.selectById(1L);
        System.out.println("老板看到的数据为："+p3.getPrice());

        //实现乐观锁 都来修改价格数据 要判断version
    }
}
