package com.huoyun.business.product.service;

import com.huoyun.exception.BusinessException;

public interface ProductService {

    /*
     * 创建产品属性
     */
    void createVariant(String name) throws BusinessException;
}
