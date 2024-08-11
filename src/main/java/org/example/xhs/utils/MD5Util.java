package org.example.xhs.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    /**
     * 将字符串进行MD5加密
     * @param str 需要加密的字符串
     * @return 加密后的16位字符串
     */
    public static String encrypt(String str) {
        try {
            // 获取MD5摘要对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 对字符串进行加密
            md.update(str.getBytes());
            byte[] bytes = md.digest();
            // 将字节数组转换为16进制字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                String hex = Integer.toHexString(b & 0xff);
                if (hex.length() == 1) {
                    sb.append('0');
                }
                sb.append(hex);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
