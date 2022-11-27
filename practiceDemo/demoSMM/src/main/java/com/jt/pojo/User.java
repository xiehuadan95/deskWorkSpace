package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@TableName("demo_user")
public class User implements Serializable { //默认序列化编号1L
    private String name;
    private String sex;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer age;
    private final static Long serialVersionUID = 1L;
}
