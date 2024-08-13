package org.example.xhs.mapper;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.example.xhs.entity.req.Author;
import org.example.xhs.entity.rsp.AuthorRsp;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AuthorMapper {

    void insert(JSONObject data);

    List<AuthorRsp> query(@Param("param") Map<String, Object> param);

    List<AuthorRsp> list(@Param("param") Map<String, Object> param);
}
