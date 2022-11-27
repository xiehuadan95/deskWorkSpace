package factory.simpleFactory;


import mybatisplus.entity.User;
//静态工厂
public class SimpleFactory {
    public static Person getPerson(String personType) {
        if (personType == "man") {
            return new Man();
        } else if (personType == "woman") {
            return new Woman();
        }
        return null;
    }
    //方法二
    public static Person getUser(){
        return new User();
    }
}
