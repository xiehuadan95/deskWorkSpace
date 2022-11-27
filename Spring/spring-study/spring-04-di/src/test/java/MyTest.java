import com.xie.pojo.Student;
import com.xie.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student =(Student) context.getBean("student");
        System.out.println(student);
    }
    /*
    * name='小明',
    * address=Address{address='北京'},
    * books=[红楼梦, 西游记, 三国演义],
    * hobbys=[game, run, study],
    * card={身份证=1234567, 银行卡=7894561},
    *  games=[LOL, DOTA, CS],
    * wife='null',
    * info={学号=20200165, 性别=男, password=123456789, 姓名=小花}
    * */
    @Test
    public void test2(){
       ApplicationContext context = new ClassPathXmlApplicationContext("userBeans.xml");
        User user = context.getBean("user",User.class);
        User user2 = context.getBean("user2",User.class);
        System.out.println(user==user2);
    }

}
