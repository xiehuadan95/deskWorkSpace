package mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import mybatisplus.entity.User;
import mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {

    @Resource
    private UserMapper userMapper;

    /**
     * 查询名字中包含国
     * 年龄大于10且小于20 email不为空的用户
     */
    @Test
    public void test() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //column对应数据库表的列名 而不是属性名
        queryWrapper.like("name", "国");
        //左侧为%
        queryWrapper.likeLeft("name", "k");
        //  gt为>  ge为≥  lt为<  le为≤
        queryWrapper.gt("age", 10)
                .lt("age", 20)
                .isNotNull("email");
        //between 大于等于 小于等于
        // queryWrapper.between("age",0,20);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

    /**
     * 按年龄降序查询用户，如果年龄相同则按id升序排序
     */
    @Test
    public void test2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //组装排序条件
        queryWrapper.orderByDesc("age").orderByAsc("uid");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    /**
     * 删除email为空的用户
     */
    @Test
    public void test3() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int res = userMapper.delete(queryWrapper);
        System.out.println("删除的记录数：" + res);
        //之前配置了逻辑删除，所以只是把is_deleted更新为1
    }

    /**
     * 查询名字中包含花 且（年龄小于12或email为空的用户），并将这些用户的年龄设置为18,设置为user@haha.com
     */
    @Test
    public void test4() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "花")
                .and(i -> i.lt("age", 18).or().isNull("email"));
        User user = new User();
        user.setAge(18);
        user.setEmail("user@haha.com");
        int res = userMapper.update(user, queryWrapper);
        System.out.println("更新的条数为：" + res);
    }

    //查询用户名和年龄 其他的不要
    @Test
    public void test5() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age");
        //其他属性 不会返回 返回的是map泛型
        //select语句通常会和selectMaps一起出现
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    /**
     * 使用子查询
     * 查询id不大于3的所有用户的id列表
     */
    @Test
    public void test6() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //如果子查询由用户输入 容易sql注入
        queryWrapper.inSql("uid", "select uid from t_user where uid<=3");
        // 可以这么写 queryWrapper.le("uid",3);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * 查询名字中包含花 且（年龄小于等于18或email不为空的用户），并将这些用户的年龄设置为16,设置为user@updateWrapper.com
     */
    @Test
    public void test7() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("age", 16)
                .set("email", "user@updateWrapper.com")
                .like("name", "花")
                .and(i -> i.le("age", 18).or().isNotNull("email"));
        //如果有自动填充功能，必须要把user对象传进去，否则 无法实现，比如updateTime
        //不需要 可以传null
        User user = new User();
        int res = userMapper.update(user, updateWrapper);
        System.out.println("更新的条数为：" + res);
    }

    /**
     * 查询名字中含有 n,年龄大于10且小于20的用户，查询条件来源于用户输入，是可选择的
     */
    @Test
    public void test8() {
        String username = "花";
        Integer ageBegin = null;
        Integer ageEnd = 20;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), "name", username)
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
    /**
     * 查询名字中含有 n,年龄大于10且小于20的用户，查询条件来源于用户输入，是可选择的
     */
    @Test
    public void test9() {
        String username = "花";
        Integer ageBegin = null;
        Integer ageEnd = 20;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(username), User::getName, username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        users.forEach(System.out::println);
    }
    /**
     * 查询名字中包含花 且（年龄小于等于18或email不为空的用户），并将这些用户的年龄设置为16,设置为user@updateWrapper.com
     */
    @Test
    public void test10() {
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(User::getAge, 16)
                .set(User::getEmail, "user@updateWrapper.com")
                .like(User::getName, "花")
                .and(i -> i.le(User::getAge, 18).or().isNotNull(User::getEmail));
        //如果有自动填充功能，必须要把user对象传进去，否则 无法实现，比如updateTime
        //不需要 可以传null
        User user = new User();
        int res = userMapper.update(user, updateWrapper);
        System.out.println("更新的条数为：" + res);
    }




















}
