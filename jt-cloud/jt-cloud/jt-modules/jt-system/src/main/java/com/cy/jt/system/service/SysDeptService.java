package com.cy.jt.system.service;

import com.cy.jt.common.domain.Node;
import com.cy.jt.system.domain.SysDept;

import java.util.List;
import java.util.Map;

public interface SysDeptService {
    List<Map<String,Object>> selectDepts();
    List<Node> selectDeptTreeNodes();
    int insertDept(SysDept entity);
    int updateDept(SysDept entity);

}
