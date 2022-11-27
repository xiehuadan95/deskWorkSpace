package com.jt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.UserMapper;


import com.jt.pojo.UserMP;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MPTest {
    @Autowired
    private UserMapper userMapper;  //JDK动态代理

    @Test  //普通的mybatis方式
    public void get() {
        List<UserMP> list = userMapper.findAll();
        System.out.println(list);
    }

    //Mybatis CRUD操作练习
    //新增name为星期五的对象
    @Test
    public void insert() {
        UserMP user = new UserMP();
        user.setAge(18).setName("星期五").setSex("女");
        userMapper.insert(user);
        System.out.println("新增用户成功");
    }

    //更新，将name 为星期五的改为星期六
    @Test
    public void update2() {
        String oldName = "星期五";
        String newName = "星期六";
        userMapper.update(oldName, newName);
        System.out.println("更新成功！");
    }

    //删除 某一个内容 需要传参才可以
    @Test
    public void get2() {
        String name2 = "星期六";
        userMapper.delete2(name2);
        System.out.println("删除用户成功！");
    }

    /*MP的工作原理
    1).通过注解 实现对象与表一一映射.
2).通过属性注解 实现对象的属性与表中的字段一一映射.
3).将公共的方法进行抽取,抽取到BaseMapper接口中
4).将用户操作的方法对象,转化为数据库能够识别的Sql语句.
demo1: userMapper.insert(user对象)
Sql1: insert into 表名(字段名…) value (属性值…)
拼接过程:
insert into 表名(字段名…) value (属性值…)
1). 通过userMapper 查找父级接口BaseMapper
2). 根据BaseMapper 查找泛型对象 User对象.
3).根据user对象 查找指定的注解 @TableName,获取表名
4).根据user对象的属性,动态获取表中的字段.@TableField
5).在获取字段的同时,获取属性的值,最后进行sql拼接
6).MP将拼接好的Sql交给Mybatis框架处理执行.

insert into demo_user(id,name…) value (value1,value2…)
*/

    //根据ID查询
    @Test
    public void show() {
        UserMP u = userMapper.selectById(23);
        System.out.println(u);
    }

    // 对象查询  应用条件构造器
    @Test  //查询一个
    public void show1() {
        UserMP user = new UserMP();
        user.setName("孙尚香D").setSex("女");
        QueryWrapper<UserMP> qw = new QueryWrapper<>(user);
        UserMP u = userMapper.selectOne(qw);
        System.out.println(u);
    }

    @Test  //查询多个
    public void show2() {
        UserMP userMP = new UserMP();
        userMP.setSex("男");
        QueryWrapper<UserMP> qw = new QueryWrapper<>(userMP);
        List<UserMP> list = userMapper.selectList(qw);
        System.out.println(list);
    }

    /*特殊字符练习
     * 转义字符  > gt,  < lt,  = eq,>= ge, <= le ,<> ne ,between,notBetween
     * in , isNull ,isNotNull,groupBy,orderBy,orderByAsc,orderByDesc
     * */
    @Test
    public void show3() {
        QueryWrapper<UserMP> qw = new QueryWrapper<>();
        qw.gt("age", 1000);
        List<UserMP> u = userMapper.selectList(qw);
        for (UserMP user : u) {
            System.out.println(user);
        }
    }

    @Test
    public void show4() {
        QueryWrapper<UserMP> qw = new QueryWrapper();
        qw.gt("age", 2000).lt("id", 200);
        List<UserMP> u = userMapper.selectList(qw);
        for (UserMP userMP : u) {
            System.out.println(userMP);
        }
    }

    @Test
    public void show5() {
        QueryWrapper<UserMP> qw = new QueryWrapper<>();
        qw.gt("age", 500).eq("sex", "女").lt("id", 100);
        List<UserMP> u = userMapper.selectList(qw);
        System.out.println(u);
    }
    @Test
    public void show6(){
        QueryWrapper<UserMP> qw = new QueryWrapper();
        qw.gt("age", 18).lt("id", 100).ne("sex", "男");
        List<UserMP> userMPS = userMapper.selectList(qw);
        System.out.println(userMPS);
    }
    @Test //between
    public void show7(){
        QueryWrapper<UserMP> qw = new QueryWrapper();
        qw.between("age", 18, 200).eq("sex","女");
        List<UserMP> userMPS = userMapper.selectList(qw);
        System.out.println(userMPS);
        qw.notBetween("id", 20, 30);
        List<UserMP> userMP = userMapper.selectList(qw);
        System.out.println(userMP);
    }
    @Test //is null
    public void show8(){
        QueryWrapper<UserMP> qw = new QueryWrapper();
        qw.isNull("name");
        List<UserMP> userMPS = userMapper.selectList(qw);
        System.out.println(userMPS);
    }
    @Test //is notNull
    public void show9(){
        QueryWrapper<UserMP> qw = new QueryWrapper();
        qw.isNotNull("id");
        List<UserMP> userMPS = userMapper.selectList(qw);
        System.out.println(userMPS);
    }
    @Test //groupBy
    public void show10(){
       QueryWrapper<UserMP> qw = new QueryWrapper();

        qw.groupBy("name");
        List<UserMP> userMPS = userMapper.selectList(qw);
        System.out.println(userMPS);
        qw.groupBy("name", "age");
        List<UserMP> userMPS2 = userMapper.selectList(qw);
        System.out.println(userMPS2);
    }
    @Test //orderByDesc
    public void show11(){
        Boolean flag=true;
        QueryWrapper<UserMP> qw = new QueryWrapper();
        qw.orderByDesc("age");
        List<UserMP> userMPS = userMapper.selectList(qw);
        System.out.println(userMPS);
    }
    @Test //orderBy
    public void show12(){
         Integer id=30;
        QueryWrapper<UserMP> qw = new QueryWrapper();
        qw.orderBy(id>20,true,"age" );
        List<UserMP> userMPS = userMapper.selectList(qw);
        System.out.println(userMPS);
    }
    @Test /*要求: 查询name中包含"精" 并且按照age 降序排列
     * Sql: like "%精%"  包含精
     *      like "精%"   以精开头
     *      like "%精"   以精结尾*/
    public void show13(){
        QueryWrapper<UserMP> qw = new QueryWrapper();
        qw.like("name","精")
                .or()
                .like("name","香")
                .orderByDesc("id");
        List<UserMP> userMPS = userMapper.selectList(qw);
        System.out.println(userMPS);
    }
    @Test
    public void show15(){
        QueryWrapper<UserMP> qw = new QueryWrapper();
        qw.likeLeft("name","精");
        List<UserMP> userMPS = userMapper.selectList(qw);
        System.out.println(userMPS);
    }
    @Test //in
    public void show16(){
        Integer [] ids={1,3,5,11,20,21};
        QueryWrapper<UserMP> qw = new QueryWrapper();
        qw.in("id",ids).orderByDesc("name");
        List<UserMP> userMPS = userMapper.selectList(qw);
        System.out.println(userMPS);
    }
    /**
     * 动态sql查询:
     *  要求: 根据 age 属性与sex属性进行查询.
     *       如果其中数据为null 则不参与where条件的拼接
     *     where age>18 and  sex="男"
     *  错误Sql:
     *      SELECT id,name,age,sex FROM demo_user WHERE (age > ? AND sex = ?)
     *      18(Integer), null
     *  MP实现动态查询:
     *       参数1: condition  boolean类型数据 true 拼接条件
     *                                        false 不拼接条件
     *       参数2: 字段名称
     *       参数3: 字段值
     */
    @Test //条件构造器 经过判断 再进行是否增加条件
    public void show17(){
        Integer age=18;
        String  sex="男";
        boolean flag= StringUtils.hasLength(sex);
        QueryWrapper<UserMP> qw = new QueryWrapper();
        qw.gt(age<10, "age", 200)
                .eq(flag,"sex","女");
        List<UserMP> userMPS = userMapper.selectList(qw);
        System.out.println(userMPS);
        qw.lt(age>10,"age","200");
        List<UserMP> userMPS2 = userMapper.selectList(qw);
        System.out.println(userMPS2);
    }
    /**
 * demo1:只查询 name,age字段信息
 * 挑选查询的字段信息
 * queryWrapper.select("name","age");
 */
    @Test
    public void show18(){
        QueryWrapper<UserMP> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age").lt("age", 200);
        List<UserMP> user =userMapper.selectList(queryWrapper);
        System.out.println(user);
    }
    @Test  //只返回查询的 name  age 字段的信息
    public void show19(){
        QueryWrapper<UserMP> qw = new QueryWrapper<>();
        qw.select("name","age").lt("age", 200);
        List<Map<String, Object>> maps = userMapper.selectMaps(qw);
        System.out.println(maps);
    }
    @Test  // selectObjs 只显示第一列的信息
    public void show20(){
        QueryWrapper<UserMP> qw = new QueryWrapper<>();
        qw.select("name","id")
                .lt("age",100)
                .eq("sex","女");
        List<Object> user = userMapper.selectObjs(qw);
        System.out.println(user);
    }



}




