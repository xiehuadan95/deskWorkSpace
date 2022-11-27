package com.cy.jt.system.service.impl;

import com.cy.jt.common.domain.Node;
import com.cy.jt.system.dao.SysMenuDao;
import com.cy.jt.system.domain.SysMenu;
import com.cy.jt.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;

    /**
     * 查询所有菜单。
     * @return
     */
    @Override
    public List<SysMenu> selectMenus() {
        return sysMenuDao.selectMenus();
    }


    @Override
    public List<Node> selectMenuTreeNodes() {
        return sysMenuDao.selectMenuTreeNodes();
    }

    @Override
    public int insertMenu(SysMenu entity) {
        return sysMenuDao.insertMenu(entity);
    }

    @Override
    public SysMenu selectById(Integer id) {
        return sysMenuDao.selectById(id);
    }

    /**
     * 更新菜单信息
     * @param entity
     * @return
     */
    @Override
    public int updateMenu(SysMenu entity) {
        return sysMenuDao.updateMenu(entity);
    }


}
