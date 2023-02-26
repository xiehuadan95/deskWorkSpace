package com.xie.srb.sms.client.fallback;

import com.xie.srb.sms.client.CoreUserInfoClent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Author:Eric
 * DATE:2023/2/26-15:24
 * Decription: 回调 如果远程调用不成果 调用备选方案
 */
@Service
@Slf4j
public class CoreUserInfoClientFallback implements CoreUserInfoClent {
    @Override
    public boolean checkMobile(String mobile) {
        log.error("远程调用失败，服务熔断");
        //直接返回 手机号不重复
        return false;
    }
}
