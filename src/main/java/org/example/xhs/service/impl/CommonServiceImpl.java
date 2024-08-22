package org.example.xhs.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.example.xhs.constans.CommonConstants;
import org.example.xhs.exception.ApiException;
import org.example.xhs.service.ICommonService;
import org.example.xhs.utils.CommonUtil;
import org.example.xhs.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
@Transactional(rollbackFor = Exception.class)
public class CommonServiceImpl implements ICommonService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void getVerifyCode(String param) {
        if (StringUtils.isEmpty(param)){
            throw new ApiException("请输入邮箱地址或者手机号");
        }
        //TODO 正则匹配输入的字符串检测是邮箱地址还是手机号, 随机数和有效期后续改为数据字典
        String key = CommonConstants.USER_VERIFY_CODE + param;
        String verifyCode = CommonUtil.getVerifyCode(6);
        redisUtil.setWithExpiration(key, verifyCode, 5, TimeUnit.MINUTES);
    }
}
