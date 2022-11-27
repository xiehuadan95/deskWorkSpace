package com.xie.srb.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "网站积分等级接口")
@RestController
@RequestMapping("/api/core/intergralGrade")
public class IntegralGradeController {

    @ApiOperation("测试接口")
    @GetMapping("/test")
    public void test(){
        return;
    }
}
