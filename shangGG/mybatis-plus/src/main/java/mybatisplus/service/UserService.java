package mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mybatisplus.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    //自定义业务内容
    List<User> listAllByName(String name);

}
