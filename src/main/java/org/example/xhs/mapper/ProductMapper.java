package org.example.xhs.mapper;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {

    /**
     * 新增到Product
     * @param data
     */
    void insert(JSONObject data);
}
