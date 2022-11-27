package mybatisplus;

import mybatisplus.entity.User;
import mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class MapperTest {
   @Resource
   UserMapper userMapper;

   @Test
   void testInsert(){
      User user =new User();
      user.setName("观海200");
      user.setAge(200);
      user.setEmail("jianguo5@qq.com");
      int res = userMapper.insert(user);
      System.out.println("结果"+res);
   }
   @Test
   public void testSelect(){
      User user = userMapper.selectById(2);
      System.out.println(user);

      List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
      users.forEach(System.out::println);

      HashMap<String, Object> map = new HashMap<>();
      map.put("name","jack");
      map.put("age",18);
      List<User> users1 = userMapper.selectByMap(map);
      users1.forEach(System.out::println);
   }
 @Test
   public void testUpdate(){
    User user = new User();
    user.setName("建国更新");
    user.setAge(100);
  user.setId(1500133241527472134L);
     //null null 动态sql判断，如果属性值为null不修改为null
     int i = userMapper.updateById(user);
     System.out.println("结果"+i);

 }
 @Test
   public void testDelte(){

    int res = userMapper.deleteById(1500133241527472130L);
    System.out.println("结果"+res);
 }
 @Test
    public void selectAllByName(){
     List<User> list = userMapper.selectAllByName("jack");
     list.forEach(System.out::println);

 }

}
