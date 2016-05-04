package com.huoyun.api.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.huoyun.api.Api;
import com.huoyun.api.product.dto.Variant;
import com.huoyun.business.product.service.ProductService;
import com.huoyun.exception.BusinessException;

@RestController
@RequestMapping("/api/product")
public class ProductController extends Api {

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/createVariant", method = RequestMethod.POST)
    public @ResponseBody void createVariant(@RequestBody Variant variant)
            throws BusinessException {
        this.productService.createVariant(variant.getName());
    }

}
