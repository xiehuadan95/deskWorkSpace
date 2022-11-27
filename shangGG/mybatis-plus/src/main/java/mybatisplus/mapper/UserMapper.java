package mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import mybatisplus.entity.User;

import java.util.List;

//@Repository
public interface UserMapper extends BaseMapper<User> {
    //自定义一个方法 具体的xml实现在resources下面的mapper文件中
    //扩展mapper
    List<User> selectAllByName(String name);
    //第一个参数为分页对象  第二个为查询条件  根据年龄来查询用户 并分页展示
    IPage<User> selectPageVo(IPage<?> page, Integer age);


}
