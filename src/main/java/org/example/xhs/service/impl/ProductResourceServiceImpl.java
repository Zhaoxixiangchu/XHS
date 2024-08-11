package org.example.xhs.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.xhs.entity.req.ProductResource;
import org.example.xhs.mapper.ProductResourceMapper;
import org.example.xhs.service.IProductResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class ProductResourceServiceImpl implements IProductResourceService {

    @Autowired
    private ProductResourceMapper productResourceMapper;

    @Override
    public void insert(List<ProductResource> list) {
        productResourceMapper.insert(list);
    }

    @Override
    public void deleteByProductId(String productId) {
        productResourceMapper.deleteByProductId(productId);
    }
}
