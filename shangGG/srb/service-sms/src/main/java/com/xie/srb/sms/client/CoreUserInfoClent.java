package com.xie.srb.sms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Author:Eric
 * DATE:2023/2/26-11:14
 * Decription: 代表远程调用的一个客户端 需要调用core服务的 userinfo
 */
@FeignClient(value = "service-core")
public interface CoreUserInfoClent {

    @GetMapping("/api/core/userInfo/checkMobile/{mobile}")
    boolean checkMobile (@PathVariable String mobile);
}
