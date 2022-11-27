package com.cy.jt.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = -2226628638555193069L;
    private Integer id;
    private String name;
    private String url;
    private Integer type;
    private Integer sort;
    private String remark;
    private Integer parentId;
    private String parentName;
    private String permission;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;
}
