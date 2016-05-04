package com.huoyun.business.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huoyun.business.product.entity.Variant;
import com.huoyun.business.product.repository.VariantRepository;
import com.huoyun.business.product.service.ProductService;
import com.huoyun.core.common.BoService;
import com.huoyun.exception.BusinessException;

@Service
public class ProductServiceImpl extends BoService implements ProductService{

    
    @Autowired
    private VariantRepository variantRepository;
    
    @Override
    public void createVariant(String name) throws BusinessException {
        Variant variant = this.boFacade.create(Variant.class);
        variant.setName(name);
        this.variantRepository.save(variant);
    }

}
