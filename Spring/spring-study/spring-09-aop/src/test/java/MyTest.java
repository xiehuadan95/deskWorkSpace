import com.xie.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //动态代理代理的是接口 所以这里不能用实现类！
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}
