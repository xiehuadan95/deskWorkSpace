package mybatisplus;

import mybatisplus.entity.User;
import mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Resource
    private UserService userService;
    //统计总数
    @Test
    public void test(){
        int count = userService.count();
        System.out.println("总记录数："+count);
    }
    @Test//批量增加 5条记录
    public void testSaveBatch(){
        List<User> list = new ArrayList<>();
        for (int  i = 0;  i < 2;  i++) {
            User user = new User();
            user.setAge(10+i);
            user.setName("花花"+i);
            list.add(user);
        }
        //返回是否成功
        boolean res = userService.saveBatch(list);
        System.out.println("插入是否成功"+res);
    }
    @Test
    public void testByName(){
        List<User> users = userService.listAllByName("jack");
        users.forEach(System.out::println);
    }
}
