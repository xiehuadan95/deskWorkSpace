package com.xie.srb.sms.web.api;

import com.xie.common.myselfAssert.Assert;
import com.xie.common.result.ResponseEnum;
import com.xie.common.result.Result;
import com.xie.common.util.RandomUtils;
import com.xie.common.util.RegexValidateUtils;
import com.xie.srb.sms.client.CoreUserInfoClent;
import com.xie.srb.sms.service.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @Resource
    private CoreUserInfoClent coreUserInfoClent;

    @ApiOperation("获取验证码")
    @GetMapping("/send/{mobile}")
    public Result send(
            @ApiParam(value = "手机号", required = true)
            @PathVariable String mobile) {
        //手机号进行校验 非空
        Assert.notEmpty(mobile, ResponseEnum.MOBILE_NULL_ERROR);
        //合法性 校验
        Assert.isTrue(RegexValidateUtils.checkCellphone(mobile),ResponseEnum.MOBILE_ERROR);
        //需要判断手机号是否已经注册，如果已经注册 就不用发送验证码了
        //此时需要用service-core中的userInfo 远程调用
        boolean res = coreUserInfoClent.checkMobile(mobile);
//        r.getData().get("isExist")
        log.info("手机号是否已存在 res="+res);
        Assert.isTrue(res==false,ResponseEnum.MOBILE_EXIST_ERROR);

        //如果service-core服务宕掉了 就干脆不断言了 先把验证码发过去 避免了远程调用失败，做一个熔断处理
        //相当于应用功能降级了 不检测

        String code=RandomUtils.getFourBitRandom();
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("code",code );
//        smsService.send(mobile, SmsProperties.TEMPLATE_CODE,map);

        log.info("验证码为：{}"+code);
        //验证码存入redis
        redisTemplate.opsForValue().set("srb:sms:code:"+mobile,code,1, TimeUnit.MINUTES);

        return Result.ok().msg("短信发送成功").data("验证码：",code);
    }












}
