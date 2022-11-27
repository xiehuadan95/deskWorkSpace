package com.cy.jt.system.service.impl;

import com.cy.jt.common.domain.Node;
import com.cy.jt.system.dao.SysDeptDao;
import com.cy.jt.system.domain.SysDept;
import com.cy.jt.system.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptDao sysDeptDao;

    @Override
    public List<Map<String, Object>> selectDepts() {
        List<Map<String, Object>> list=
                sysDeptDao.selectDepts();
        return list;
    }
    @Override
    public List<Node> selectDeptTreeNodes() {
        List<Node> list=
                sysDeptDao.selectDeptTreeNodes();
        return list;
    }
    @Override
    public int updateDept(SysDept entity) {
      int  rows=sysDeptDao.updateDept(entity);

        return rows;
    }

    @Override
    public int insertDept(SysDept entity) {
        int rows=sysDeptDao.insertDept(entity);
        return rows;
    }

}
