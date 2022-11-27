package com.jt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.UserMP;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper  //为接口创建了反射机制一个对象 //MP规则：BaseMapper<T> MP要操作的表是谁 ？ T必须引入对象
public interface UserMapper extends BaseMapper<UserMP> {
    //查询全部用户信息 访问修饰符 返回值类型 方法名（参数）
    //用的 mybatis的方式 不是 plus
    List<UserMP> findAll();
    //新增
    @Insert("insert into demo_user(name,id,sex,age) value(#{name},null,#{sex},#{age}) ")
    void insertM();
    @Update("update demo_user set name=#{name} where name=#{name2}")
    void update(String name,String name2);
    @Delete("delete from demo_user where name=#{name}")
    void delete2(String name);

}
