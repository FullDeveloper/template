package com.template.common.util;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Author: zrb
 * Date: 2018/5/28
 * Time: 14:27
 * Description: RSA签名验签类
 */
public class RSASignature {

    /**
     * 签名算法
     */
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    /**
     * RSA签名
     *
     * @param content    待签名数据
     * @param privateKey 商户私钥
     * @param encode     字符集编码
     * @return 签名值
     */
    public static String sign(String content, String privateKey, String encode) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));

            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update(content.getBytes(encode));

            byte[] signed = signature.sign();

            return Base64.encode(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String sign(String content, String privateKey) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);
//            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);
            java.security.Signature signature = java.security.Signature.getInstance("MD5withRSA");
            signature.initSign(priKey);
            signature.update(content.getBytes());
            byte[] signed = signature.sign();
            return Base64.encode(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * RSA验签名检查
     *
     * @param content   待签名数据
     * @param sign      签名值
     * @param publicKey 分配给开发商公钥
     * @param encode    字符集编码
     * @return 布尔值
     */
    public static boolean doCheck(String content, String sign, String publicKey, String encode) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decode(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

            java.security.Signature signature = java.security.Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);
            signature.update(content.getBytes(encode));

            return signature.verify(Base64.decode(sign));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean doCheck(String content, String sign, String publicKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decode(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

            java.security.Signature signature = java.security.Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);
            signature.update(content.getBytes());

            return signature.verify(Base64.decode(sign));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public static void main(String[] args) throws Exception {
        String filepath = "D:/";
      /*  System.out.println("--------------公钥加密私钥解密过程-------------------");
        String plainText = "ihep_公钥加密私钥解密";
        //公钥加密过程
        byte[] cipherData = RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)), plainText.getBytes());
        String cipher = Base64.encode(cipherData);
        System.out.println("加密之后的数据:" + cipher);

        //私钥解密过程
        byte[] res = RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)), Base64.decode(cipher));
        String restr=new String(res);
        System.out.println("原文："+plainText);
        System.out.println("加密："+cipher);
        System.out.println("解密："+restr);
        System.out.println();

        System.out.println("--------------私钥加密公钥解密过程-------------------");
        plainText="ihep_私钥加密公钥解密";
        //私钥加密过程
        cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)),plainText.getBytes());
        cipher=Base64.encode(cipherData);
        //公钥解密过程
        res=RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)), Base64.decode(cipher));
        restr=new String(res);
        System.out.println("原文："+plainText);
        System.out.println("加密："+cipher);
        System.out.println("解密："+restr);
        System.out.println();
*/
        System.out.println("---------------私钥签名过程------------------");
        String content="aid=19920920180520145611&mer_orderid=CEISHI123123001";
        String signstr=RSASignature.sign(content,RSAEncrypt.loadPrivateKeyByFile(filepath));
        System.out.println("签名原串："+content);
        System.out.println("签名串："+signstr);
        System.out.println();

    /*    System.out.println("---------------公钥校验签名------------------");
        System.out.println("签名原串："+content);
        System.out.println("签名串："+signstr);

        System.out.println("验签结果："+RSASignature.doCheck(content, signstr, RSAEncrypt.loadPublicKeyByFile(filepath)));
        System.out.println();*/

    }

}
