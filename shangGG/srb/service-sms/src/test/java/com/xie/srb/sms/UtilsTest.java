package com.xie.srb.sms;

import com.xie.srb.sms.util.SmsProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author:Eric
 * DATE:2023/2/19-17:05
 * Decription:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UtilsTest {
    @Test
    public void testProperties(){
        System.out.println(SmsProperties.REGION_ID);
        System.out.println(SmsProperties.KEY_ID);
        System.out.println(SmsProperties.KEY_SECRET);
        System.out.println(SmsProperties.TEMPLATE_CODE);
        System.out.println(SmsProperties.SIGN_NAME);
    }

}