package org.example.xhs.mapper;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorMapper {

    void insert(JSONObject data);
}
