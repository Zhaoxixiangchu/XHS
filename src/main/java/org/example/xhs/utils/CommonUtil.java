package org.example.xhs.utils;

import cn.hutool.captcha.generator.RandomGenerator;

public class CommonUtil {

    public static String getVerifyCode(int length) {
        int len = 6;
        if (length > 0){
            len = length;
        }
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", len);
        return randomGenerator.generate();
    }
}
