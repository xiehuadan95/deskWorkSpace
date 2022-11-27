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
public class RsaUtils {
    /**
     * 算法名称
     */
    private static final String ALGORITHM = "RSA";
    /**
     * 签名算法 MD5withRSA 或 SHA1WithRSA 、SHA256WithRSA 等
     */
    public static final String SIGNATURE_ALGORITHM = "SHA256WithRSA";
    /**
     * 密钥长度默认建议是2048位:
     *
     */
    private static final int KEY_SIZE = 2048;
    /**
     * RSA2最大加密明文大小
     * 加密的明文最大长度 = 密钥长度 - 11（单位是字节，即byte）
     */
    private static final int MAX_ENCRYPT_BLOCK = 245;

    /**
     * RSA2最大解密密文大小
     * 解密的密文最大长度 = 密钥长度
     */
    private static final int MAX_DECRYPT_BLOCK = 256;

    private RsaUtils() {
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

    /**
     * 私钥字符串转PrivateKey实例
     *
     * @param privateKey 私钥字符串
     * @return
     */
    public static PrivateKey getPrivateKey(String privateKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        // 对私钥进行Base64编码解密
        byte[] decodedKey = Base64.getDecoder().decode(privateKey.getBytes("UTF-8"));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 公钥字符串转PublicKey实例
     *
     * @param publicKey 公钥字符串
     * @return
     */
    public static PublicKey getPublicKey(String publicKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        // 对公钥进行Base64编码解密
        byte[] decodedKey = Base64.getDecoder().decode(publicKey.getBytes("UTF-8"));
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
        return keyFactory.generatePublic(keySpec);
    }

    /**
     * 公钥加密
     *
     * @param data      待加密数据
     * @param publicKey 公钥
     * @return
     */
    public static String encryptByPublicKey(String data, PublicKey publicKey) {
        try (
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ) {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            int inputLen = data.getBytes("UTF-8").length;
            int offset = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offset > 0) {
                if (inputLen - offset > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(data.getBytes("UTF-8"), offset, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data.getBytes("UTF-8"), offset, inputLen - offset);
                }
                out.write(cache, 0, cache.length);
                i++;
                offset = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptedData = out.toByteArray();
            // 获取加密内容使用Base64进行编码加密,并以UTF-8为标准转化成字符串
            // 加密后的字符串
            //return new String(Base64.encodeBase64String(encryptedData));
            return new String(Base64.getEncoder().encode(encryptedData), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 私钥解密
     *
     * @param data       待解密数据
     * @param privateKey 私钥
     * @return
     */
    public static String decryptByPrivateKey(String data, PrivateKey privateKey) {
        try (
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ) {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            // 对待解密数据进行Base64编码解密
            byte[] dataBytes = Base64.getDecoder().decode(data.getBytes("UTF-8"));
            int inputLen = dataBytes.length;
            int offset = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offset > 0) {
                if (inputLen - offset > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(dataBytes, offset, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(dataBytes, offset, inputLen - offset);
                }
                out.write(cache, 0, cache.length);
                i++;
                offset = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            // 解密后的内容
            return new String(decryptedData, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 私钥签名
     *
     * @param data       待签名数据
     * @param privateKey 私钥
     * @return 签名
     */
    public static String sign(String data, PrivateKey privateKey) throws Exception {
        byte[] keyBytes = privateKey.getEncoded();
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        PrivateKey key = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(key);
        signature.update(data.getBytes());
        // 对签名内容进行Base64编码加密
        return new String(Base64.getEncoder().encode(signature.sign()));
    }

    /**
     * 公钥验签
     *
     * @param srcData   原始字符串
     * @param publicKey 公钥
     * @param sign      签名
     * @return 是否验签通过
     */
    public static boolean verify(String srcData, PublicKey publicKey, String sign) throws Exception {
        byte[] keyBytes = publicKey.getEncoded();
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        PublicKey key = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(key);
        signature.update(srcData.getBytes());
        // 对验签结果进行Base64编码解密
        return signature.verify(Base64.getDecoder().decode(sign.getBytes()));
    }

}