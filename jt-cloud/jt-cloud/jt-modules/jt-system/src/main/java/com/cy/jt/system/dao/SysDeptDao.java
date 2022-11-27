package com.cy.jt.system.dao;

import com.cy.jt.common.domain.Node;
import com.cy.jt.system.domain.SysDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysDeptDao {
    @Select("select c.*,p.name parentName from sys_depts c left join sys_depts p on c.parentId=p.id")
    List<Map<String,Object>> selectDepts();

    @Select("select id,name,parentId from sys_depts")
    List<Node> selectDeptTreeNodes();

    int updateDept(SysDept entity);
    int insertDept(SysDept entity);

}
