package mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mybatisplus.entity.User;
import mybatisplus.mapper.UserMapper;
import mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

// 继承ServiceImpl就 拥有了 IService里面的方法，已经重写过了 可以不用写，注意泛型
// ServiceImpl<M extends BaseMapper<T>, T> implements IService<T>  第一个表示继承了BaseMapper 的类 我们的是UserMapper，
//第二个T表示BaseMapper管理的那个T 也就是我们定义的User
//如果以后要实现自己的特殊的逻辑 可以在自己定义的UserService中重新定义重写
@Service //实现类就创建好了
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

//    @Resource
//    private UserMapper userMapper;

//    public class ServiceImpl<M extends BaseMapper<T>, T> implements IService<T> {
//    @Autowired
//    protected M baseMapper;
    //userMapper继承了BaseMapper这里的 M即是我们传入 的UserMapper  这里已经注入了 protected M baseMapper 所以可以直接用
    @Override
    public List<User> listAllByName(String name) {

        return baseMapper.selectAllByName(name);
    }
}
