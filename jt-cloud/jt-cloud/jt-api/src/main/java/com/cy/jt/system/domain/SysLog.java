package com.cy.jt.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysLog implements Serializable {
    private static final long serialVersionUID = 3026130983201917569L;
    private Integer id;
    private String ip;
    private String username;
    private String operation;
    private String method;
    private String params;
    private Long time;
    private Integer status;
    private String error;
    private Date createdTime;
}
