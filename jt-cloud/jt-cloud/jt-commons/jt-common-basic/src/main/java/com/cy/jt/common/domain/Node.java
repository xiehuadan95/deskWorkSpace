package com.cy.jt.common.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Node implements Serializable {
    private static final long serialVersionUID = 9026943093451970051L;
    private Integer id;
    private String name;
    private Integer parentId;
}
