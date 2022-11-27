package com.cy.jt.system.web.controller;

import com.cy.jt.common.domain.JsonResult;
import com.cy.jt.system.domain.SysDept;
import com.cy.jt.system.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept/")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    @GetMapping
    public JsonResult doSelectDepts() {
        return new JsonResult(sysDeptService.selectDepts());
    }

    @GetMapping("treeNodes")
    public JsonResult doSelectZTreeNodes() {
        return new JsonResult(sysDeptService.selectDeptTreeNodes());
    }

    @PutMapping
    public JsonResult doUpdateDept(@RequestBody SysDept entity){
        sysDeptService.updateDept(entity);
        return new JsonResult("update ok");
    }

    @PostMapping
    public JsonResult doInsertDept(@RequestBody SysDept entity){
        sysDeptService.insertDept(entity);
        return new JsonResult("save ok");
    }

}
