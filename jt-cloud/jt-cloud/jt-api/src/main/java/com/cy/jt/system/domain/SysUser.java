package com.cy.jt.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class SysUser implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String mobile;
    private String email;
    private Integer valid=1;//默认为有效状态,0代表无效
    private Integer deptId;
    private String  deptName;
    private List<Integer> roleIds;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;

}
