package com.xie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
//在企业中 所有的pojo都会序列化 序列化完以后可正常传输
public class User implements Serializable {
    //没有序列化的对象
    private  String name;
    private  Integer age;
}
