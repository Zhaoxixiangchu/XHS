package org.example.xhs.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.xhs.entity.req.ProductResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductResourceMapper {

    void insert(@Param("list") List<ProductResource> list);

    void deleteByProductId(@Param("productId") String productId);
}
