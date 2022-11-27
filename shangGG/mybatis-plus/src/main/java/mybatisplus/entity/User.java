package mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import factory.simpleFactory.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_user") //映射表名
public class User implements Person {
    //MP 默认雪花算法  也可以设置
    // @TableId(type= IdType.ASSIGN_ID) private String id; 也可以在配置文件设置全局设置  如果用uuid 主键必须为varchar类型
    @TableId(value = "uid", type = IdType.AUTO) //这个属性必须叫做id MP才能识别为主键， 如果直接修改为uid 则需要加上@TableId注解告诉MP
    private Long id;
    // @TableField(value = "username")
    private String name;
    @TableField(fill = FieldFill.INSERT)
    private Integer age;
    private String email;
    //代码层面实现自动更新时间数据的功能，就可以兼容很多数据库，mysql oracle等各类数据库的解决方案是不一样的，所以放代码层面注解处理会兼容一点
    //自动填充 自动填充的内容 需要自定义一个实现类 MetaObjectHandler 元数据，重写insert update方法
   @TableField(fill =FieldFill.INSERT )
    private LocalDateTime createTime;  //驼峰命名自动映射数据库的 create_time 字段
    @TableField(fill = FieldFill.INSERT_UPDATE)  //数据增加的时候自动填充，修改的时候自动填充
    private LocalDateTime updateTime;
   // 逻辑删除字段 默认 0表示false 1表示true 配置文件可全局配置
    @TableLogic
    @TableField(value = "is_deleted") //映射数据库的逻辑删除字段
    private Boolean deleted;

    @Override
    public void run() {
        System.out.println("user can run");
    }

    @Override
    public void eat() {
        System.out.println("user can eat");
    }

    @Override
    public void think() {
        System.out.println("user can think");
    }

     /*自定义 1为未删除 -1为已删除 需要去配置
    @TableLogic
    @TableField(value = "is_deleted")
    private Integer deleted;*/

}
