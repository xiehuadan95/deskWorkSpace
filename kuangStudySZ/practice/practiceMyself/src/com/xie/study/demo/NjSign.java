package com.xie.study.demo;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class NjSign {
    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, SignatureException {
        String partnerPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAs2apRviSIkBEF++6EPFsOjzLVtJO4f3NcU8YlegJaDtU5D6jmp9LTUCHIDdDw+RAhIZ06hrEwRmy9+QjRcvAEQQCvbLNUOp/qx7QTPCNBP1JSLZJA2/PChlO+lv+HxkPUHHzLQqrMCXUGVxe3UJ5xlpj7lKVxhl/P59R6SFG6/zMnahwFTSKh6ED8rq4f1rML2T/TiIAlcx45TWtAsU5PTGZ9QbsMi6W4IU4qk3c5uQZh1/FUPKTROOU194Fz5ZnMJleUoX9Q5hhUnV14mmoG4LBraqYirSz4iE6HISsxtlkUHIxZj4TOJ3v3lxx2EEC1li/AywmOKmRNTOcGRHmZwIDAQAB";
        String myPrivateKey="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCrRB5rTfjpQBPdaDWFAvx7tDlVv4wLXAj3C89V9QfmRfXXrG7UAkvj/FgVL3PH5ntRPSzLJzcNSap7WTGhwAECgjgImLB56vZIYAIb2khBME9wTItRJ9Qa1vxAcK68rDmMYoBAK0V0fTzxNs3kAsiPkvSIodDSvS2K+/ZDb6pwSvsJDC7Dqbt5h7afvmObRTF/AS/ocoXBuvs4CQctqNVRMgw9RETKAjYuhYfIBIaAsi5i8qOs2ZGOfq6dCMsf5Zu1fNXcAy/PzQrhbDcFybaEWMx8A5Hl/braIuwxGlWqHBTWBDUHoB8xkC8a+1ZQwAP1JfnS9qnhD0nppO4eXLv7AgMBAAECggEATMkqtkNsMO+ouGDLdgpDtxazig1qNYGbB2BFIi3Mz+JX+c12lxk8e0gdGcp/p4VfjqnV1nOLjCqWA92WkgWqrjxB8SC8Jr1AlGxvJZu1P3zwcNHwuH8Z6rquuBmNTkwNNTLIe3yrFDI+S4udvfe9ghmKB2Q9Yu6sZ57V56A+Ez/e5CgoOsXyjbGVGq4pUnMaDxC1ftUfptGYEWs9Y9tQJsVAPtLG+CXjfCbu8lAKGwFW5JODoWGFDVRUxTEy5/ZznbSaFyxY/FNbIsSYL1LRWQC5KAt8BBjvNyCfAC0rP/5+toWIXFiMAZjg0iSSLR/kbyzAQ2f5gZY2oZps4JtqmQKBgQDanl/RdAG4xm1vB5pInFzvYj8XnrrlaWAZx1rytu57Kc/UeDSrHFfGQLdlseGCbaLTW+oCbI5WPpekI/XtLySKLEQXMGwLhGUvYUfLnppmNGDI5/OU+vG61q8yv6+GkolPbQzEfqV+j1/iCSG29yN0fUicZ01Vwp8XbHsw9pWMVwKBgQDIjPlcxYbE+Xsw1/d2ZLoPXoFAXF/GFpl2sbmZfFdlMR7p2mFaCLi4YcPlI+cWafaoDjxEZxkfSQZlerh7fwtAJYow9FGWnUhx3DN74RByuD1YyfGdluJlIWX+CdmaNKYz3gIoMjHEFWL6Z7efmL3srJddXe2t2CFzmWQgQpEG/QKBgFWhTxq1e68qWdbxfWcPh/9j1h6kV8RgH/o48dC8AnFPkU5Bvy9+rIrE8pDsuc3ir7JmACTu7FmvrqnmQ/+hRYixigIjP07Lju6eBgclmoiJ35cR84DZQjHSwVD5cAEgCJSJvESC7sPB2OaqeQA3kTWhlP1eIRaEYthD74TgMPeFAoGBAI0BycZ3v4U5IGu8PWsJ8WQi/1/AUzqU4zv4Q9Xt/gjRG7oy6GYEYdSKMNEoiC9TO7D3qVoy3xAHKS8qtRFnxwJIIry+26q5VZlwyOYd3ZG7hq6p9m7mCrIuZGbUiCILSJyJSRz4BdOncds8F3hoTYld5GMqSpYDs6lyvVqNUykFAoGAbKqTZ+zMq2W7W/O9W8rdOem/RG0dgUSO9voiYvb2YpRjPkEWsTrUAGSLIdGVB4VzEyjrofHdEIbK4YbbU2219E664nHGga66/OqG6JVSt0mEZVwKAZizyMv1LrbaD6pt8Y+ckdwL3Wf3JzrU7RMJJA8yQaBV9ZBxvtZAUOerotI=";

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] decodedKey = Base64.getDecoder().decode(partnerPublicKey.getBytes("UTF-8"));
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        String data="{\"timeStamp\":\"1640087673842\",\"name\":\"胡仕定\",\"nonceStr\":\"bc33bde4f8af4bfcb742b559170ebf91\"}";
        //这个流可以不用关闭
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
//   加密好的数据为aQj/uvAp1/LQxa/AYJZYFX29LOg+ufeOJzwR5oOQTP4/gZJP09MNfbTQ398Qdv3t63BTQELNXiSKQVfZyqvxRh7z5IoZ+wO3L7Agb4MdaJMr6xOi8DTjPmuMM16gPcc8yNs5vGLM5iFtpD3q8oKcS9AY5pQNES0NwhPfnc86XebhzfgFNItEA5MWvSNfxoz7AYFz4Cp4ClbQtOVhKjVp6qw/F7F1AZ/bHKld4eXJCjsGzAb9Be5N4jePAsJGB+vYlclmle7lAi7jIeMKoxJ6Ia8Y9egl52n6UZhx7MpbAb7v3lBLJ7D7A7QA066dwEtzewhSug/rWJZUYFcoAMR4wQ==
//加签 用自己
        byte[] decodedKey2 = Base64.getDecoder().decode(myPrivateKey.getBytes("UTF-8"));
        PKCS8EncodedKeySpec  keySpec2 = new PKCS8EncodedKeySpec(decodedKey2);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec2);
        data="aQj/uvAp1/LQxa/AYJZYFX29LOg+ufeOJzwR5oOQTP4/gZJP09MNfbTQ398Qdv3t63BTQELNXiSKQVfZyqvxRh7z5IoZ+wO3L7Agb4MdaJMr6xOi8DTjPmuMM16gPcc8yNs5vGLM5iFtpD3q8oKcS9AY5pQNES0NwhPfnc86XebhzfgFNItEA5MWvSNfxoz7AYFz4Cp4ClbQtOVhKjVp6qw/F7F1AZ/bHKld4eXJCjsGzAb9Be5N4jePAsJGB+vYlclmle7lAi7jIeMKoxJ6Ia8Y9egl52n6UZhx7MpbAb7v3lBLJ7D7A7QA066dwEtzewhSug/rWJZUYFcoAMR4wQ==";
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
    }

}
