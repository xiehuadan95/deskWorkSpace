package com.xie.study.demo;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class NjRsa {
    public static void main(String[] args)throws Exception{
    /*
    平台服务方私钥
    私钥:MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCzZqlG+JIiQEQX77oQ8Ww6PMtW0k7h/c1xTxiV6AloO1TkPqOan0tNQIcgN0PD5ECEhnTqGsTBGbL35CNFy8ARBAK9ss1Q6n+rHtBM8I0E/UlItkkDb88KGU76W/4fGQ9QcfMtCqswJdQZXF7dQnnGWmPuUpXGGX8/n1HpIUbr/MydqHAVNIqHoQPyurh/WswvZP9OIgCVzHjlNa0CxTk9MZn1BuwyLpbghTiqTdzm5BmHX8VQ8pNE45TX3gXPlmcwmV5Shf1DmGFSdXXiaagbgsGtqpiKtLPiITochKzG2WRQcjFmPhM4ne/eXHHYQQLWWL8DLCY4qZE1M5wZEeZnAgMBAAECggEAIbBuq3A0aRAueVxAUbw0eb8+5B/8Rj4WHWggEs6PLa6uo2oL6RZu2qP6fBdEt32ejAR/4hKCzkxYKmsCILJBcDCTnzH7km1m6iiQL1Kg+MXjxC7PCUEu3ROhnCw4TXi0QoQTiWrOeO0xpk2NVvmLyq7gwzlo/Nl+5uCxThk8q0XuBABywVeT8lG8J3HXk4UWeFP6l5FPMGrZCKPnvxvSfqSzR0m1cm+Zl1Mslsinql86he6+S8oGhTywA9DU9yn48TXGlcr0OCFDqIBgpXhUF0MQzB/Zqm0MA5kWuTc16UNP9zeC4tsaiWZXzhaJB91RSTDpTuFtUWmJEtCczCcdqQKBgQDrQjSQj6BdXo7BSyCGUP3JxFlz9zLFg1DIM12Uht32dxVkA5IIgHEGl7D2LNl0KvoKourePRLQCo5FChj2liGb4JWoJVmo9Gs7tVgAPCkb3MnneFKvc+qRXbVw+Bj5l3YTyTG6YAsM1spMupdLyzBmhDZj2JC4Yy46fbo/8e/PPQKBgQDDN7+IM+1i+aa6scuD4W1BX+g5vvvnWmmwFNE+d3X8ZNGuhx8Ma4PHA5DtmfJ/GEC9I/UDJew8o4qOt4QEzZp709ZejNOXXtmycUlI2MysdCgzJnUEBVKU07vXvQT7Kwktp5EhNjVorZD3GubYFHZ923rwG22ESB6+HK2kMTPmcwKBgQDc2XrlFp/R5xmWZYNz9AY7akMbdT1JY9vrBSVdcDpgzCvdhuiJaKIyMSbkAvhkcI/oekaIOMc3XCFwuGj0271TSsLTZbTEwicEl1m0ZsWkrWExFahxoxzaOCFDmvQ/IqurKV2we8cD14N0AlpTwbx/ELDKjJxXLGxSZoL40pNwdQKBgQC2ulftha2OF2CZIBL/PuKlbsBQTRQ9WcPTraiub+NgfH5IfvHxDjIq9ouR26fAj1MJt75/U9/sYqgvLlfEpy8S+RaPKgJkjcP341JVfZkXUyLNvhGJ0fGanRYWujcPYxkUQuT10Wfss4odwnCRkZXX+Lj6RrIcP+WGzhE6v1N1QQKBgQDnqmwpilXRtE5sG7xv19hTPXzNTSiGy+NLx1pKg3987mddKpnRmW6xAVUnVERSenvT+eWjUFcUSy2nv6YAslO4gEtKnTbx/r461rrVQhAsPBh2FRYMYMCWwCbl7ymbzO2v/ABYMJN9UdMS6zHScA4O3qByYBOmpyDFGe7E37XQMA==
    请求方公钥
    公钥:MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq0Qea0346UAT3Wg1hQL8e7Q5Vb+MC1wI9wvPVfUH5kX116xu1AJL4/xYFS9zx+Z7UT0syyc3DUmqe1kxocABAoI4CJiweer2SGACG9pIQTBPcEyLUSfUGtb8QHCuvKw5jGKAQCtFdH088TbN5ALIj5L0iKHQ0r0tivv2Q2+qcEr7CQwuw6m7eYe2n75jm0UxfwEv6HKFwbr7OAkHLajVUTIMPUREygI2LoWHyASGgLIuYvKjrNmRjn6unQjLH+WbtXzV3AMvz80K4Ww3Bcm2hFjMfAOR5f262iLsMRpVqhwU1gQ1B6AfMZAvGvtWUMAD9SX50vap4Q9J6aTuHly7+wIDAQAB
 */

    //平台服务方公钥，在微服务平台查询
    String partnerPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAs2apRviSIkBEF++6EPFsOjzLVtJO4f3NcU8YlegJaDtU5D6jmp9LTUCHIDdDw+RAhIZ06hrEwRmy9+QjRcvAEQQCvbLNUOp/qx7QTPCNBP1JSLZJA2/PChlO+lv+HxkPUHHzLQqrMCXUGVxe3UJ5xlpj7lKVxhl/P59R6SFG6/zMnahwFTSKh6ED8rq4f1rML2T/TiIAlcx45TWtAsU5PTGZ9QbsMi6W4IU4qk3c5uQZh1/FUPKTROOU194Fz5ZnMJleUoX9Q5hhUnV14mmoG4LBraqYirSz4iE6HISsxtlkUHIxZj4TOJ3v3lxx2EEC1li/AywmOKmRNTOcGRHmZwIDAQAB";
    String partPrivateKey="MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCzZqlG+JIiQEQX77oQ8Ww6PMtW0k7h/c1xTxiV6AloO1TkPqOan0tNQIcgN0PD5ECEhnTqGsTBGbL35CNFy8ARBAK9ss1Q6n+rHtBM8I0E/UlItkkDb88KGU76W/4fGQ9QcfMtCqswJdQZXF7dQnnGWmPuUpXGGX8/n1HpIUbr/MydqHAVNIqHoQPyurh/WswvZP9OIgCVzHjlNa0CxTk9MZn1BuwyLpbghTiqTdzm5BmHX8VQ8pNE45TX3gXPlmcwmV5Shf1DmGFSdXXiaagbgsGtqpiKtLPiITochKzG2WRQcjFmPhM4ne/eXHHYQQLWWL8DLCY4qZE1M5wZEeZnAgMBAAECggEAIbBuq3A0aRAueVxAUbw0eb8+5B/8Rj4WHWggEs6PLa6uo2oL6RZu2qP6fBdEt32ejAR/4hKCzkxYKmsCILJBcDCTnzH7km1m6iiQL1Kg+MXjxC7PCUEu3ROhnCw4TXi0QoQTiWrOeO0xpk2NVvmLyq7gwzlo/Nl+5uCxThk8q0XuBABywVeT8lG8J3HXk4UWeFP6l5FPMGrZCKPnvxvSfqSzR0m1cm+Zl1Mslsinql86he6+S8oGhTywA9DU9yn48TXGlcr0OCFDqIBgpXhUF0MQzB/Zqm0MA5kWuTc16UNP9zeC4tsaiWZXzhaJB91RSTDpTuFtUWmJEtCczCcdqQKBgQDrQjSQj6BdXo7BSyCGUP3JxFlz9zLFg1DIM12Uht32dxVkA5IIgHEGl7D2LNl0KvoKourePRLQCo5FChj2liGb4JWoJVmo9Gs7tVgAPCkb3MnneFKvc+qRXbVw+Bj5l3YTyTG6YAsM1spMupdLyzBmhDZj2JC4Yy46fbo/8e/PPQKBgQDDN7+IM+1i+aa6scuD4W1BX+g5vvvnWmmwFNE+d3X8ZNGuhx8Ma4PHA5DtmfJ/GEC9I/UDJew8o4qOt4QEzZp709ZejNOXXtmycUlI2MysdCgzJnUEBVKU07vXvQT7Kwktp5EhNjVorZD3GubYFHZ923rwG22ESB6+HK2kMTPmcwKBgQDc2XrlFp/R5xmWZYNz9AY7akMbdT1JY9vrBSVdcDpgzCvdhuiJaKIyMSbkAvhkcI/oekaIOMc3XCFwuGj0271TSsLTZbTEwicEl1m0ZsWkrWExFahxoxzaOCFDmvQ/IqurKV2we8cD14N0AlpTwbx/ELDKjJxXLGxSZoL40pNwdQKBgQC2ulftha2OF2CZIBL/PuKlbsBQTRQ9WcPTraiub+NgfH5IfvHxDjIq9ouR26fAj1MJt75/U9/sYqgvLlfEpy8S+RaPKgJkjcP341JVfZkXUyLNvhGJ0fGanRYWujcPYxkUQuT10Wfss4odwnCRkZXX+Lj6RrIcP+WGzhE6v1N1QQKBgQDnqmwpilXRtE5sG7xv19hTPXzNTSiGy+NLx1pKg3987mddKpnRmW6xAVUnVERSenvT+eWjUFcUSy2nv6YAslO4gEtKnTbx/r461rrVQhAsPBh2FRYMYMCWwCbl7ymbzO2v/ABYMJN9UdMS6zHScA4O3qByYBOmpyDFGe7E37XQMA==";
    //请求方私钥
    String myPrivateKey="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCrRB5rTfjpQBPdaDWFAvx7tDlVv4wLXAj3C89V9QfmRfXXrG7UAkvj/FgVL3PH5ntRPSzLJzcNSap7WTGhwAECgjgImLB56vZIYAIb2khBME9wTItRJ9Qa1vxAcK68rDmMYoBAK0V0fTzxNs3kAsiPkvSIodDSvS2K+/ZDb6pwSvsJDC7Dqbt5h7afvmObRTF/AS/ocoXBuvs4CQctqNVRMgw9RETKAjYuhYfIBIaAsi5i8qOs2ZGOfq6dCMsf5Zu1fNXcAy/PzQrhbDcFybaEWMx8A5Hl/braIuwxGlWqHBTWBDUHoB8xkC8a+1ZQwAP1JfnS9qnhD0nppO4eXLv7AgMBAAECggEATMkqtkNsMO+ouGDLdgpDtxazig1qNYGbB2BFIi3Mz+JX+c12lxk8e0gdGcp/p4VfjqnV1nOLjCqWA92WkgWqrjxB8SC8Jr1AlGxvJZu1P3zwcNHwuH8Z6rquuBmNTkwNNTLIe3yrFDI+S4udvfe9ghmKB2Q9Yu6sZ57V56A+Ez/e5CgoOsXyjbGVGq4pUnMaDxC1ftUfptGYEWs9Y9tQJsVAPtLG+CXjfCbu8lAKGwFW5JODoWGFDVRUxTEy5/ZznbSaFyxY/FNbIsSYL1LRWQC5KAt8BBjvNyCfAC0rP/5+toWIXFiMAZjg0iSSLR/kbyzAQ2f5gZY2oZps4JtqmQKBgQDanl/RdAG4xm1vB5pInFzvYj8XnrrlaWAZx1rytu57Kc/UeDSrHFfGQLdlseGCbaLTW+oCbI5WPpekI/XtLySKLEQXMGwLhGUvYUfLnppmNGDI5/OU+vG61q8yv6+GkolPbQzEfqV+j1/iCSG29yN0fUicZ01Vwp8XbHsw9pWMVwKBgQDIjPlcxYbE+Xsw1/d2ZLoPXoFAXF/GFpl2sbmZfFdlMR7p2mFaCLi4YcPlI+cWafaoDjxEZxkfSQZlerh7fwtAJYow9FGWnUhx3DN74RByuD1YyfGdluJlIWX+CdmaNKYz3gIoMjHEFWL6Z7efmL3srJddXe2t2CFzmWQgQpEG/QKBgFWhTxq1e68qWdbxfWcPh/9j1h6kV8RgH/o48dC8AnFPkU5Bvy9+rIrE8pDsuc3ir7JmACTu7FmvrqnmQ/+hRYixigIjP07Lju6eBgclmoiJ35cR84DZQjHSwVD5cAEgCJSJvESC7sPB2OaqeQA3kTWhlP1eIRaEYthD74TgMPeFAoGBAI0BycZ3v4U5IGu8PWsJ8WQi/1/AUzqU4zv4Q9Xt/gjRG7oy6GYEYdSKMNEoiC9TO7D3qVoy3xAHKS8qtRFnxwJIIry+26q5VZlwyOYd3ZG7hq6p9m7mCrIuZGbUiCILSJyJSRz4BdOncds8F3hoTYld5GMqSpYDs6lyvVqNUykFAoGAbKqTZ+zMq2W7W/O9W8rdOem/RG0dgUSO9voiYvb2YpRjPkEWsTrUAGSLIdGVB4VzEyjrofHdEIbK4YbbU2219E664nHGga66/OqG6JVSt0mEZVwKAZizyMv1LrbaD6pt8Y+ckdwL3Wf3JzrU7RMJJA8yQaBV9ZBxvtZAUOerotI=";
    //请求方公钥
        String myPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq0Qea0346UAT3Wg1hQL8e7Q5Vb+MC1wI9wvPVfUH5kX116xu1AJL4/xYFS9zx+Z7UT0syyc3DUmqe1kxocABAoI4CJiweer2SGACG9pIQTBPcEyLUSfUGtb8QHCuvKw5jGKAQCtFdH088TbN5ALIj5L0iKHQ0r0tivv2Q2+qcEr7CQwuw6m7eYe2n75jm0UxfwEv6HKFwbr7OAkHLajVUTIMPUREygI2LoWHyASGgLIuYvKjrNmRjn6unQjLH+WbtXzV3AMvz80K4Ww3Bcm2hFjMfAOR5f262iLsMRpVqhwU1gQ1B6AfMZAvGvtWUMAD9SX50vap4Q9J6aTuHly7+wIDAQAB";
    //对入参data进行加密 用平台服务方公钥 先获取平台服务方公钥
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] decodedKey = Base64.getDecoder().decode(partnerPublicKey.getBytes("UTF-8"));
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
    //获取银行方私钥 privateKey
        byte[] decodedKey2 = Base64.getDecoder().decode(myPrivateKey.getBytes("UTF-8"));
        PKCS8EncodedKeySpec  keySpec2 = new PKCS8EncodedKeySpec(decodedKey2);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec2);
     //获取银行方公钥
        byte[] decodedKey3 = Base64.getDecoder().decode(myPublicKey.getBytes("UTF-8"));
        X509EncodedKeySpec keySpec3 = new X509EncodedKeySpec(decodedKey3);
        PublicKey yhPublicKey = keyFactory.generatePublic(keySpec3);
        //获取平台服务方私钥
        byte[] decodedKey4 = Base64.getDecoder().decode(partPrivateKey.getBytes("UTF-8"));
        PKCS8EncodedKeySpec  keySpec4 = new PKCS8EncodedKeySpec(decodedKey4);
        PrivateKey partnerPrivateKey = keyFactory.generatePrivate(keySpec4);
    //平台公钥进行加密
        //
        String data="{\"timeStamp\":\"1640087673842\",\"name\":\"胡仕定\",\"nonceStr\":\"bc33bde4f8af4bfcb742b559170ebf91\"}";
        try (
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ) {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            int inputLen = data.getBytes("UTF-8").length;
            int offset = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offset > 0) {
                if (inputLen - offset > 245) {
                    cache = cipher.doFinal(data.getBytes("UTF-8"), offset, 245);
                } else {
                    cache = cipher.doFinal(data.getBytes("UTF-8"), offset, inputLen - offset);
                }
                out.write(cache, 0, cache.length);
                i++;
                offset = i * 245;
            }
            byte[] encryptedData = out.toByteArray();
            // 获取加密内容使用Base64进行编码加密,并以UTF-8为标准转化成字符串
            // 加密后的字符串.............
            data= new String(Base64.getEncoder().encode(encryptedData), "UTF-8");
        } catch (Exception e) {
            System.out.println("对数据加密出现错误"+e);
        }
        System.out.println("加密好的数据为"+data);
    //pXqRI2cIkCCqqCMgKkAC+MY9pvIqsJfBcAEiGovzgJUVCNXWDfNUGJVDuZ4egCc8/MyH0a3REKVveuf5W/PJbIfDhhnsR9XlU8m+UIvMmKj+rhHrf/bM4vW0FOZkj7emPs9wyS4KOlHN3gwEfpT5KW/E30cc6WEBgFKKAc/eWGmd4MEHBhUAVOULPhWraUt1Ix10DDCIrFTDs8mE2MHPtpgNMn3CzLq1U/mpFe2ZeQkCHwXlPYDONBIEKFWGe8J1eV8cpGV/Ej0oedYVLRvrrkw2LMTfwGYkwbe0biSS8D/lFGJTNVyYeZVoI/qjW8GTaZ9Tr7OTfEO+ymWgwKLabg==

    //加签 用自己的私钥
        byte[] keyBytes = privateKey.getEncoded();
        PKCS8EncodedKeySpec keySpecs = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactorys = KeyFactory.getInstance("RSA");
        PrivateKey keys = keyFactorys.generatePrivate(keySpecs);
        Signature signature = Signature.getInstance("SHA256WithRSA");
        signature.initSign(keys);
        signature.update(data.getBytes());
       String sign= new String(Base64.getEncoder().encode(signature.sign()));
        System.out.println("银行方生成的签名："+sign);

    String resultData=data;
        System.out.println("加密后的内容："+resultData);
    String resultSign=sign;
        System.out.println("签名为："+resultSign);
    // String yhPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq0Qea0346UAT3Wg1hQL8e7Q5Vb+MC1wI9wvPVfUH5kX116xu1AJL4/xYFS9zx+Z7UT0syyc3DUmqe1kxocABAoI4CJiweer2SGACG9pIQTBPcEyLUSfUGtb8QHCuvKw5jGKAQCtFdH088TbN5ALIj5L0iKHQ0r0tivv2Q2+qcEr7CQwuw6m7eYe2n75jm0UxfwEv6HKFwbr7OAkHLajVUTIMPUREygI2LoWHyASGgLIuYvKjrNmRjn6unQjLH+WbtXzV3AMvz80K4Ww3Bcm2hFjMfAOR5f262iLsMRpVqhwU1gQ1B6AfMZAvGvtWUMAD9SX50vap4Q9J6aTuHly7+wIDAQAB";
    //生成银行方的公钥验签 yhPublicKey
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
