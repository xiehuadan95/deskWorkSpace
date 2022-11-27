package com.cy.jt.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class SysDept implements Serializable {
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer sort;
    private String remark;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;

}
