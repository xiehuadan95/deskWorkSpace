package com.xie.srb.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Author:Eric
 * DATE:2023/2/28-23:06
 * Decription: 用户绑定的枚举
 */
@AllArgsConstructor
@Getter
public enum UserBindEnum {
    NO_BIND(0,"未绑定"),
    BIND_OK(1,"绑定成功"),
    BIND_FAIL(-1,"绑定失败"),
    ;

    private Integer status;
    private String msg;
}
