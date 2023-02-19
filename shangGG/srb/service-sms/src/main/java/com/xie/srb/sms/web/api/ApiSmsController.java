package com.xie.srb.sms.web.api;

import com.xie.common.exception.Assert;
import com.xie.common.result.ResponseEnum;
import com.xie.common.result.Result;
import com.xie.common.util.RandomUtils;
import com.xie.common.util.RegexValidateUtils;
import com.xie.srb.sms.service.SmsService;
import com.xie.srb.sms.util.SmsProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Author:Eric
 * DATE:2023/2/19-20:30
 * Decription: 发送短信控制层
 */
@RestController
@RequestMapping("/api/sms")
@Api(tags = "短信管理")
@CrossOrigin
@Slf4j
public class ApiSmsController {
    @Resource
    private SmsService smsService;

    @Resource
    private RedisTemplate redisTemplate;

    @ApiOperation("获取验证码")
    @GetMapping("/send/{mobile}")
    public Result send(
            @ApiParam(value = "手机号", required = true)
            @PathVariable String mobile) {
        //手机号进行校验 非空
        Assert.notEmpty(mobile, ResponseEnum.MOBILE_NULL_ERROR);
        //合法性 校验
        Assert.isTrue(RegexValidateUtils.checkCellphone(mobile),ResponseEnum.MOBILE_ERROR);
        String code=RandomUtils.getFourBitRandom();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",code );
        smsService.send(mobile, SmsProperties.TEMPLATE_CODE,map);

        //验证码存入redis
        redisTemplate.opsForValue().set("srb:sms:code:"+mobile,code,1, TimeUnit.MINUTES);

        return Result.ok().msg("短信发送成功");
    }












}
