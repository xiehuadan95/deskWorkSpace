package com.xie.study.util;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * RSA算法加密/解密和签名/验签工具类
 * 生成密钥对（公钥和私钥）
 * 加密内容与签名内容进行Base64加密解密（有利于HTTP协议下传输）
 * @author admin
 */
public class KeyUtils {
    /**
     * 算法名称
     */
    private static final String ALGORITHM = "RSA";
    /**
     * 密钥长度默认建议是2048位:
     *
     */
    private static final int KEY_SIZE = 2048;


    private KeyUtils() {
    }

    /**
     * 获取密钥对
     *
     * @return 密钥对
     */
    public static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM);
        generator.initialize(KEY_SIZE);
        return generator.generateKeyPair();
    }

    public static void main(String[] args) {
        try {
            // 生成密钥对
            KeyPair keyPair = getKeyPair();
            String privateKey = new String(Base64.getEncoder().encode(keyPair.getPrivate().getEncoded()), "UTF-8");
            String publicKey = new String(Base64.getEncoder().encode(keyPair.getPublic().getEncoded()), "UTF-8");
            System.out.println("私钥:" + privateKey);
            System.out.println("公钥:" + publicKey);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("加密解密异常");
        }
    }
}