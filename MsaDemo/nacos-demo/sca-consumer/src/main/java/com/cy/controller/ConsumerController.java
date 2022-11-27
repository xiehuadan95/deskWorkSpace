package com.cy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate loadBalancedRestTemplate;

//    @GetMapping("/doRestEcho3")
//    public String doLoadBalanceRestTemplateEcho(){
//        String url=String.format("http://sca-provider/provider/echo/%s",consumerName);
//        //向服务提供方发起http请求,获取响应数据
//        return loadBalancedRestTemplate.getForObject(
//                url,//要请求的服务的地址
//                String.class);//String.class为请求服务的响应结果类型
//    }

}
