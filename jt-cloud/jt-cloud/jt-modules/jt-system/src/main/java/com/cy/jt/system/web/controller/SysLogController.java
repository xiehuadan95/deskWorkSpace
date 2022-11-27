package com.cy.jt.system.web.controller;

import com.cy.jt.common.domain.JsonResult;
import com.cy.jt.system.domain.SysLog;
import com.cy.jt.system.service.SysLogService;
import com.cy.jt.system.web.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log/")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @GetMapping("{id}")
    public JsonResult doSelectById (Long id) {
        return new JsonResult(sysLogService.selectById(id));
    }

    @DeleteMapping("{ids}")
    public JsonResult doDeleteById (Long...ids) {
        sysLogService.deleteById(ids);
        return new JsonResult("delete ok");
    }

    @GetMapping
    public JsonResult doSelectLogs(SysLog sysLog){
        return new JsonResult(
                PageUtils.startPage()//启动分页查询拦截
                        .doSelectPageInfo(()-> //分页查询日志信息
                                sysLogService.selectLogs(sysLog)
                        ));
    }

}
