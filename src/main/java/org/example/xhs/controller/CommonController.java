package org.example.xhs.controller;

import org.example.xhs.response.AjaxResult;
import org.example.xhs.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/common")
@RestController
public class CommonController {

    @Autowired
    private ICommonService commonService;

    @GetMapping("/getVerifyCode")
    public AjaxResult getVerifyCode(String param){
        commonService.getVerifyCode(param);
        return AjaxResult.success();
    }
}
