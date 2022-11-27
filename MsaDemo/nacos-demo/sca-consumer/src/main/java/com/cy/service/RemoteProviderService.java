package com.cy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/*
* 描述接口时，用于告诉Spring要为此接口创建实现类
* vale值 为你要调用的服务名
* contextId= 接口名 首字母小写 避免接口多了以后 混乱
* */
@FeignClient(value="sca-provider",contextId = "remoteProviderService")
public interface RemoteProviderService {
    @GetMapping("/provider/echo/{msg}")
    String doEcho(@PathVariable("msg") String msg);

}
