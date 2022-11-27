package com.cy.jt.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class SysRole implements Serializable {
    /**角色id*/
    private Integer id;
    /**角色名称*/
    private String name;
    /**菜单id*/
    private List<Integer> menuIds;
    /**备注*/
    private String remark;
    /**创建时间*/
    private Date createdTime;
    /**修改时间*/
    private Date modifiedTime;
    /**创建用户*/
    private String createdUser;
    /**修改用户*/
    private String modifiedUser;

}
