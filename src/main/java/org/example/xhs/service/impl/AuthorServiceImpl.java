package org.example.xhs.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.example.xhs.mapper.AuthorMapper;
import org.example.xhs.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
