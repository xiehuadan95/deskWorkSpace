package com.xie.srb.sms.service;

import java.util.Map;

/**
 * Author:Eric
 * DATE:2023/2/19-18:10
 * Decription: 发送短信验证码给手机
 */
public interface SmsService {

    void send(String mobile, String templateCode, Map<String,Object> param);
}
