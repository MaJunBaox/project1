package com.majunbao.utils;

/**
 * author : Majunbao
 * date : 2019/6/3 15:30
 * description :Md5 加密
 */

import android.util.Log;

/**
 * MD5编码
 */
public class MD5 {

    /**
     * md5加密
     *
     * @param source 对字符串加密
     */
    public static String encode(String source) {
        return encode(source.getBytes());
    }

    /**
     * md5加密
     *
     * @param source 对byte数组加密
     */
    private static String encode(byte[] source) {
        String s = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            s = new String(str);
        } catch (Exception e) {
            Log.e("MD5", e.toString());
        }
        return s;
    }
}

