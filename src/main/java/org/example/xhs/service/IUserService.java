package org.example.xhs.service;

import com.alibaba.fastjson.JSONObject;
import org.example.xhs.entity.req.User;

public interface IUserService {

    /**
     * 用户登录
     * @param user
     * @param type 登录方式 1:用户名 2：验证码
     * @return
     */
    JSONObject login(User user, Integer type);

    /**
     * 用户注册
     * @param user
     */
    void register(User user);
}
