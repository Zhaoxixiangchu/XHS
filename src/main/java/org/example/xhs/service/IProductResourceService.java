package org.example.xhs.service;

import org.example.xhs.entity.req.ProductResource;

import java.util.List;

public interface IProductResourceService {

    void insert(List<ProductResource> list);

    void deleteByProductId(String productId);
}
