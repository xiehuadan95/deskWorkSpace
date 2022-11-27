package com.cy.jt.system.service;

import com.cy.jt.system.domain.SysLog;

import java.util.List;

public interface SysLogService {
    /**
     * 基于条件查询日志信息
     * @param sysLog
     * @return
     */
    List<SysLog> selectLogs(SysLog sysLog);

    /**
     * 基于id查询日志信息
     * @param id
     * @return
     */
    SysLog selectById(Long id);

    /**
     * 新增日志信息
     * @param sysLog
     */
    void insertLog(SysLog sysLog);

    /**
     * 基于id删除日志记录
     * @param id
     * @return
     */
    int deleteById(Long... id);

}
