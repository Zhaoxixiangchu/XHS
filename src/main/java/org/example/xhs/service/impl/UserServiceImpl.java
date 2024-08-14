package org.example.xhs.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.example.xhs.constans.CommonConstants;
import org.example.xhs.entity.req.User;
import org.example.xhs.entity.rsp.UserRsp;
import org.example.xhs.exception.ApiException;
import org.example.xhs.mapper.UserMapper;
import org.example.xhs.service.IUserService;
import org.example.xhs.utils.MD5Util;
import org.example.xhs.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public JSONObject login(User user, Integer type) {
        JSONObject object = new JSONObject();

        if (type == 1) {
            if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassWord())) {
                throw new ApiException("请输入用户名和密码");
            }
            String userName = user.getUserName();
            String password = user.getPassWord();

            String encryptPassword = MD5Util.encrypt(userName + "_" + password);

            UserRsp userRsp = userMapper.login(userName, encryptPassword);
            if (userRsp == null) {
                throw new ApiException("用户名或密码不正确");
            }
            object.put("user", userRsp);
        } else if (type == 2) {
            if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassWord())) {
                throw new ApiException("请输入手机号和验证码");
            }
            String userName = user.getUserName();
            String password = user.getPassWord();
            String key = CommonConstants.USER_VERIFY_CODE + userName;
            String code = (String) redisUtil.get(key);
            if (StringUtils.isEmpty(code)) {
                throw new ApiException("验证码已过期");
            } else {
                if (code.equals(password)) {
                    redisUtil.delete(key);
                    UserRsp userRsp = userMapper.login(userName, null);
                    if (userRsp == null) {
                        throw new ApiException("用户不存在，请检查是否输入错误");
                    }
                    object.put("user", userRsp);
                } else {
                    throw new ApiException("验证码错误");
                }
            }

        }
        return object;
    }

    @Override
    public void register(User user) {
        if (StringUtils.isEmpty(user.getUserName())) {
            throw new ApiException("清输入用户名");
        }
        if (StringUtils.isEmpty(user.getPassWord())) {
            throw new ApiException("请输入密码");
        }
        int count = userMapper.checkExist(user.getUserName());
        if (count >= 1) {
            throw new ApiException("该用户名已存在，请重新输入");
        }
        String password = MD5Util.encrypt(user.getUserName() + "_" + user.getPassWord());
        user.setPassWord(password);
        user.setIsEnable(1);
        user.setCreateDate(new Date());
        userMapper.add(user);
    }
}
