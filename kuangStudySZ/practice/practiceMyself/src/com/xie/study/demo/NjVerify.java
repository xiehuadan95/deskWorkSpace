package com.xie.study.demo;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class NjVerify {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        /*
        * 加密好的数据为NmhcyoPfJVkZqfdv+Akka1FnRZ7dTRzlerEiFCrGKJ4VdSVDtdIijT7jTo6tW/jwmoTEPMY874yxOxH0gXgq6G0PH7orBbVN1jKLnGGElhGxAXrcQ7RNx/f2AZlDWP2GNIDCkAaF02HQxROcdAXHNlLnsAGSAuL8h7LQucGnkASpj92jcUpKub3lwnCFWvx2Cv7rn3zhCddLmba/Y7aFxAA4jRxbU4HQ4ktZyP6NbeJbghLpvA9wg3VGsMMceOsL4v99DC67DsLpPRb7CR0nISpinbLhoW4IJ48MLevr/QiHDIEkjdx2Oijkw2pipiGnZojCyr8LtCUChB2Bwu+39g==
银行方生成的签名：SNr7mTafbEjckIp3cR7oDkCseZjpZKnCd+drybvv5UJtJATzodeovOY7jMI6u7xQwvWDwprmrd9WDuaXXALa8x7z4d+r84DP7psHboifh0qky8gwitb0EqXlQERk4RAaRnyQSwb2arZhb9UbL69Vp55Z1L8EM90efvaIuiXKCf7XVnLQ4FlRZBsMpbWPDkNi8aawniiiu0pQvMTbazJNJzr3ONEceorgMtJcm5BBFv45tn9CtVXhWNZXx+eLF5ytQZj1FdL5hQ9K8/K2F3Fqgujc6KZiVZhcDD/J/5+JGDjRwXThejTgVm8HNAYISMzqLgXi3rFjVIEQcIM/GS1RWA==
加密后的内容：aQj/uvAp1/LQxa/AYJZYFX29LOg+ufeOJzwR5oOQTP4/gZJP09MNfbTQ398Qdv3t63BTQELNXiSKQVfZyqvxRh7z5IoZ+wO3L7Agb4MdaJMr6xOi8DTjPmuMM16gPcc8yNs5vGLM5iFtpD3q8oKcS9AY5pQNES0NwhPfnc86XebhzfgFNItEA5MWvSNfxoz7AYFz4Cp4ClbQtOVhKjVp6qw/F7F1AZ/bHKld4eXJCjsGzAb9Be5N4jePAsJGB+vYlclmle7lAi7jIeMKoxJ6Ia8Y9egl52n6UZhx7MpbAb7v3lBLJ7D7A7QA066dwEtzewhSug/rWJZUYFcoAMR4wQ==
签名为：SNr7mTafbEjckIp3cR7oDkCseZjpZKnCd+drybvv5UJtJATzodeovOY7jMI6u7xQwvWDwprmrd9WDuaXXALa8x7z4d+r84DP7psHboifh0qky8gwitb0EqXlQERk4RAaRnyQSwb2arZhb9UbL69Vp55Z1L8EM90efvaIuiXKCf7XVnLQ4FlRZBsMpbWPDkNi8aawniiiu0pQvMTbazJNJzr3ONEceorgMtJcm5BBFv45tn9CtVXhWNZXx+eLF5ytQZj1FdL5hQ9K8/K2F3Fqgujc6KZiVZhcDD/J/5+JGDjRwXThejTgVm8HNAYISMzqLgXi3rFjVIEQcIM/GS1RWA==

        *
        * */
//平台方私钥（自己的私钥解密）
        String partPrivateKey="MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCzZqlG+JIiQEQX77oQ8Ww6PMtW0k7h/c1xTxiV6AloO1TkPqOan0tNQIcgN0PD5ECEhnTqGsTBGbL35CNFy8ARBAK9ss1Q6n+rHtBM8I0E/UlItkkDb88KGU76W/4fGQ9QcfMtCqswJdQZXF7dQnnGWmPuUpXGGX8/n1HpIUbr/MydqHAVNIqHoQPyurh/WswvZP9OIgCVzHjlNa0CxTk9MZn1BuwyLpbghTiqTdzm5BmHX8VQ8pNE45TX3gXPlmcwmV5Shf1DmGFSdXXiaagbgsGtqpiKtLPiITochKzG2WRQcjFmPhM4ne/eXHHYQQLWWL8DLCY4qZE1M5wZEeZnAgMBAAECggEAIbBuq3A0aRAueVxAUbw0eb8+5B/8Rj4WHWggEs6PLa6uo2oL6RZu2qP6fBdEt32ejAR/4hKCzkxYKmsCILJBcDCTnzH7km1m6iiQL1Kg+MXjxC7PCUEu3ROhnCw4TXi0QoQTiWrOeO0xpk2NVvmLyq7gwzlo/Nl+5uCxThk8q0XuBABywVeT8lG8J3HXk4UWeFP6l5FPMGrZCKPnvxvSfqSzR0m1cm+Zl1Mslsinql86he6+S8oGhTywA9DU9yn48TXGlcr0OCFDqIBgpXhUF0MQzB/Zqm0MA5kWuTc16UNP9zeC4tsaiWZXzhaJB91RSTDpTuFtUWmJEtCczCcdqQKBgQDrQjSQj6BdXo7BSyCGUP3JxFlz9zLFg1DIM12Uht32dxVkA5IIgHEGl7D2LNl0KvoKourePRLQCo5FChj2liGb4JWoJVmo9Gs7tVgAPCkb3MnneFKvc+qRXbVw+Bj5l3YTyTG6YAsM1spMupdLyzBmhDZj2JC4Yy46fbo/8e/PPQKBgQDDN7+IM+1i+aa6scuD4W1BX+g5vvvnWmmwFNE+d3X8ZNGuhx8Ma4PHA5DtmfJ/GEC9I/UDJew8o4qOt4QEzZp709ZejNOXXtmycUlI2MysdCgzJnUEBVKU07vXvQT7Kwktp5EhNjVorZD3GubYFHZ923rwG22ESB6+HK2kMTPmcwKBgQDc2XrlFp/R5xmWZYNz9AY7akMbdT1JY9vrBSVdcDpgzCvdhuiJaKIyMSbkAvhkcI/oekaIOMc3XCFwuGj0271TSsLTZbTEwicEl1m0ZsWkrWExFahxoxzaOCFDmvQ/IqurKV2we8cD14N0AlpTwbx/ELDKjJxXLGxSZoL40pNwdQKBgQC2ulftha2OF2CZIBL/PuKlbsBQTRQ9WcPTraiub+NgfH5IfvHxDjIq9ouR26fAj1MJt75/U9/sYqgvLlfEpy8S+RaPKgJkjcP341JVfZkXUyLNvhGJ0fGanRYWujcPYxkUQuT10Wfss4odwnCRkZXX+Lj6RrIcP+WGzhE6v1N1QQKBgQDnqmwpilXRtE5sG7xv19hTPXzNTSiGy+NLx1pKg3987mddKpnRmW6xAVUnVERSenvT+eWjUFcUSy2nv6YAslO4gEtKnTbx/r461rrVQhAsPBh2FRYMYMCWwCbl7ymbzO2v/ABYMJN9UdMS6zHScA4O3qByYBOmpyDFGe7E37XQMA==";
//请求方公钥
        String myPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq0Qea0346UAT3Wg1hQL8e7Q5Vb+MC1wI9wvPVfUH5kX116xu1AJL4/xYFS9zx+Z7UT0syyc3DUmqe1kxocABAoI4CJiweer2SGACG9pIQTBPcEyLUSfUGtb8QHCuvKw5jGKAQCtFdH088TbN5ALIj5L0iKHQ0r0tivv2Q2+qcEr7CQwuw6m7eYe2n75jm0UxfwEv6HKFwbr7OAkHLajVUTIMPUREygI2LoWHyASGgLIuYvKjrNmRjn6unQjLH+WbtXzV3AMvz80K4Ww3Bcm2hFjMfAOR5f262iLsMRpVqhwU1gQ1B6AfMZAvGvtWUMAD9SX50vap4Q9J6aTuHly7+wIDAQAB";
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        //生成银行方的公钥验签 yhPublicKey
        //获取银行方公钥
        byte[] decodedKey3 = Base64.getDecoder().decode(myPublicKey.getBytes("UTF-8"));
        X509EncodedKeySpec keySpec3 = new X509EncodedKeySpec(decodedKey3);
        PublicKey yhPublicKey = keyFactory.generatePublic(keySpec3);
        //加密后的内容
        String resultData="aQj/uvAp1/LQxa/AYJZYFX29LOg+ufeOJzwR5oOQTP4/gZJP09MNfbTQ398Qdv3t63BTQELNXiSKQVfZyqvxRh7z5IoZ+wO3L7Agb4MdaJMr6xOi8DTjPmuMM16gPcc8yNs5vGLM5iFtpD3q8oKcS9AY5pQNES0NwhPfnc86XebhzfgFNItEA5MWvSNfxoz7AYFz4Cp4ClbQtOVhKjVp6qw/F7F1AZ/bHKld4eXJCjsGzAb9Be5N4jePAsJGB+vYlclmle7lAi7jIeMKoxJ6Ia8Y9egl52n6UZhx7MpbAb7v3lBLJ7D7A7QA066dwEtzewhSug/rWJZUYFcoAMR4wQ==";
        //加密后的签名
        String resultSign="SNr7mTafbEjckIp3cR7oDkCseZjpZKnCd+drybvv5UJtJATzodeovOY7jMI6u7xQwvWDwprmrd9WDuaXXALa8x7z4d+r84DP7psHboifh0qky8gwitb0EqXlQERk4RAaRnyQSwb2arZhb9UbL69Vp55Z1L8EM90efvaIuiXKCf7XVnLQ4FlRZBsMpbWPDkNi8aawniiiu0pQvMTbazJNJzr3ONEceorgMtJcm5BBFv45tn9CtVXhWNZXx+eLF5ytQZj1FdL5hQ9K8/K2F3Fqgujc6KZiVZhcDD/J/5+JGDjRwXThejTgVm8HNAYISMzqLgXi3rFjVIEQcIM/GS1RWA==";
        byte[] keyBytesy = yhPublicKey.getEncoded();
        X509EncodedKeySpec keySpecy = new X509EncodedKeySpec(keyBytesy);
        KeyFactory keyFactoryy = KeyFactory.getInstance("RSA");
        PublicKey keyy = keyFactoryy.generatePublic(keySpecy);
        Signature signaturey = Signature.getInstance("SHA256WithRSA");
        signaturey.initVerify(keyy);
        signaturey.update(resultData.getBytes());
        // 对验签结果进行Base64编码解密
        boolean isSign= signaturey.verify(Base64.getDecoder().decode(resultSign.getBytes()));
        System.out.println("验签结果：" + isSign);
        //解密

        //用平台服务方私钥解密
        //获取私钥
        byte[] decodedKey4 = Base64.getDecoder().decode(partPrivateKey.getBytes("UTF-8"));
        PKCS8EncodedKeySpec keySpec4 = new PKCS8EncodedKeySpec(decodedKey4);
        PrivateKey partnerPrivateKey = keyFactory.generatePrivate(keySpec4);

        try (
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ) {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, partnerPrivateKey);
            // 对待解密数据进行Base64编码解密
            byte[] dataBytes = Base64.getDecoder().decode(resultData.getBytes("UTF-8"));
            int inputLen = dataBytes.length;
            int offset = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offset > 0) {
                if (inputLen - offset > 256) {
                    cache = cipher.doFinal(dataBytes, offset, 256);
                } else {
                    cache = cipher.doFinal(dataBytes, offset, inputLen - offset);
                }
                out.write(cache, 0, cache.length);
                i++;
                offset = i * 256;
            }
            byte[] decryptedData = out.toByteArray();
            // 解密后的内容
            String res= new String(decryptedData, "UTF-8");
            System.out.println("解密后的内容："+res);
        } catch (Exception e) {
            System.out.println("解密出错："+e);
        }
    }
    }

