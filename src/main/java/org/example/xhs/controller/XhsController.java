package org.example.xhs.controller;

import com.alibaba.fastjson.JSONObject;
import org.example.xhs.entity.req.ParseParam;
import org.example.xhs.response.AjaxResult;
import org.example.xhs.service.IXhsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xhs")
public class XhsController {

    @Autowired
    private IXhsService xhsService;

    @PostMapping("/parse")
    public AjaxResult<JSONObject> parse(@RequestBody ParseParam parseParam){
        JSONObject result = xhsService.parseResult(parseParam);
        return new AjaxResult<>(result);
    }
}
