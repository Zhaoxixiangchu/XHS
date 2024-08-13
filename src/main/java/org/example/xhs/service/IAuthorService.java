package org.example.xhs.service;

import com.alibaba.fastjson.JSONObject;
import org.example.xhs.entity.req.Author;
import org.example.xhs.entity.rsp.AuthorRsp;
import org.example.xhs.response.PageResult;

import java.util.List;

public interface IAuthorService {


    void insert(JSONObject data);

    PageResult<AuthorRsp> query(Author author);

    /**
     * 获取author下列列表
     * @param keyWord
     * @return
     */
    List<AuthorRsp> dropList(String keyWord);
}
