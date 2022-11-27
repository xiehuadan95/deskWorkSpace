import com.xie.dao.UserDaoSql;
import com.xie.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
    //获取ApplicationContext; 拿到Spring的容器
        ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
        //容器在了，要什么get什么
        UserServiceImpl userServiceImpl = (UserServiceImpl)context.getBean("userService");
        userServiceImpl.getUser();

    }
}
