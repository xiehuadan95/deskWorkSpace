package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("demo_user")
public class UserMP {
    //对象的属性与表中的字段关联
    @TableField("name")
    private String name;
    private String sex;
    //标识主键 主键自增
    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer age;

}
