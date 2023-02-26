package com.xie.srb.sms.client;

import com.xie.srb.sms.client.fallback.CoreUserInfoClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Author:Eric
 * DATE:2023/2/26-11:14
 * Decription: 代表远程调用的一个客户端 需要调用core服务的 userinfo  将功能降级的类 写上去
 */
@FeignClient(value = "service-core",fallback = CoreUserInfoClientFallback.class)
public interface CoreUserInfoClent {

    @GetMapping("/api/core/userInfo/checkMobile/{mobile}")
    boolean checkMobile (@PathVariable String mobile);
}
