package mybatisplus;

import mybatisplus.entity.User;
import mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

//自动创建spring上下文
@SpringBootTest
class MybatisPlusApplicationTests {
    //@Autowired spring的按照类型装配
    @Resource //j2ee的注解，先按照名称装配 再类型
    private UserMapper userMapper;

    @Test
    void testSelect() {
        String num="12345".substring(0, 4);
        System.out.println(num);
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }


}
