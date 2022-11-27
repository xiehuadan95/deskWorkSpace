package com.cy.jt.system.service.impl;

import com.cy.jt.system.dao.SysLogDao;
import com.cy.jt.system.domain.SysLog;
import com.cy.jt.system.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public List<SysLog> selectLogs(SysLog sysLog) {
        return sysLogDao.selectLogs(sysLog);
    }

    @Override
    public SysLog selectById(Long id) {
        return sysLogDao.selectById(id);
    }

    @Override
    public void insertLog(SysLog sysLog) {
        sysLogDao.insertLog(sysLog);
    }

    @Override
    public int deleteById(Long... id) {
        return sysLogDao.deleteById(id);
    }

}
