package com.xie.srb.sms.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Author:Eric
 * DATE:2023/2/19-16:54
 * Decription: Sms工具类 用于读取自定义短信配置 读取配置项 实现了初始化Bean的接口自动获取配置值 并注入
 */
//从配置文件中读取这个前缀的属性
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "aliyun.sms")
public class SmsProperties implements InitializingBean {
    /*
    region-id: cn-hangzhou
    key-id: LTAI4G5Svnb2TWBMuKnNT6jy
    key-secret: N7v6R4V3EJ1SGDZlsqtqo8QyVVMmtQ
    template-code: SMS_96695065
    sign-name: 谷粒
     */
    //配置文件中找到这几个节点 自动赋值给下面几个属性
    private String regionId;
    private String keyId;
    private String keySecret;
    private String templateCode;
    private String signName;
   //赋值之后作为常量 来使用
    public static String REGION_ID;
    public static String KEY_ID;
    public static String KEY_SECRET;
    public static String TEMPLATE_CODE;
    public static String SIGN_NAME;

    //当自动设置完成值后会自动调用这个方法 在这里面给常量赋值
    @Override
    public void afterPropertiesSet() throws Exception {
        REGION_ID=regionId;
        KEY_ID=keyId;
        KEY_SECRET=keySecret;
        TEMPLATE_CODE=templateCode;
        SIGN_NAME=signName;
    }
}
