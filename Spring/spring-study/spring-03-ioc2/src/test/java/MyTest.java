import com.xie.pojo.User;
import com.xie.pojo.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserT user =(UserT) context.getBean("u3");
        user.show();
//        User user2  =(User) context.getBean("user");
//        System.out.println(user == user2); //true
    }
}
