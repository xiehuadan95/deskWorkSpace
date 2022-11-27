package com.cy.jt.system.web.controller;

import com.cy.jt.common.domain.JsonResult;
import com.cy.jt.system.domain.SysUser;
import com.cy.jt.system.service.SysUserService;
import com.cy.jt.system.web.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user/")
@RestController
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping
    public JsonResult doSelectUsers(SysUser entity){
        return new JsonResult(
                PageUtils.startPage().doSelectPageInfo(()->{
                    sysUserService.selectUsers(entity);
                }));
    }
    @PostMapping
    public JsonResult doInsertUser(@RequestBody SysUser entity){
        sysUserService.insertUser(entity);
        return new JsonResult("save ok");
    }

    @GetMapping("{id}")
    public JsonResult doSelectById(@PathVariable Integer id){
        return new JsonResult(sysUserService.selectById(id));
    }

    @PutMapping
    public JsonResult doUpdateUser(@RequestBody SysUser entity){
        sysUserService.updateUser(entity);
        return new JsonResult("update ok");
    }

    @PatchMapping("{id}/{valid}")
//少量数据的更新可使用Patch请求,当然使用put也可以.
    public JsonResult doValidById(@PathVariable Integer id,
                                  @PathVariable Integer valid){
        sysUserService.validById(id,valid);//update
        return new JsonResult("update ok");
    }

}
