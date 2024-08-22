package org.example.xhs.controller;

import com.alibaba.fastjson.JSONObject;
import org.example.xhs.entity.req.User;
import org.example.xhs.response.AjaxResult;
import org.example.xhs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login/{type}")
    public AjaxResult<JSONObject> login(@RequestBody User user, @PathVariable("type") Integer type) {
        JSONObject object = userService.login(user, type);
        return new AjaxResult<>(object);
    }

    @PostMapping("/register")
    public AjaxResult register(@RequestBody User user) {
        userService.register(user);
        return AjaxResult.success();
    }
}
