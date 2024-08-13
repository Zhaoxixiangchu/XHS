package org.example.xhs.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.example.xhs.entity.req.Author;
import org.example.xhs.entity.rsp.AuthorRsp;
import org.example.xhs.mapper.AuthorMapper;
import org.example.xhs.response.PageResult;
import org.example.xhs.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public void insert(JSONObject data) {
        authorMapper.insert(data);
    }

    @Override
    public PageResult<AuthorRsp> query(Author author) {
        PageHelper.startPage(author.getPageNum(), author.getPageSize());
        Map<String, Object> map = new HashMap<>();
        map.put("authorNickName", author.getAuthorNickName());
        map.put("authorId", author.getAuthorId());
        Page<AuthorRsp> page = (Page<AuthorRsp>) authorMapper.query(map);
        return new PageResult<>(page);
    }

    @Override
    public List<AuthorRsp> dropList(String keyWord) {
        Map<String, Object> param = new HashMap<>();
        param.put("authorNickName", keyWord);
        return authorMapper.list(param);
    }
}
