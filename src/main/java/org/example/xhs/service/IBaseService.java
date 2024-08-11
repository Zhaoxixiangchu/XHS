package org.example.xhs.service;

import com.alibaba.fastjson.JSONObject;
import org.example.xhs.entity.req.ParseParam;

public interface IBaseService {

    public JSONObject parseResult(ParseParam parseParam);
}
