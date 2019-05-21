package com.imooc.o2o.service;

import com.imooc.o2o.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> queryProduct();
    List<ProductDto> queryProductByCondition(ProductDto product);
    List<ProductDto> queryProductByShopId(Integer shopId);
    ProductDto queryProductByProductId(Integer productId);
    int updateProduct(ProductDto product);
    int insertProduct(ProductDto product);
}
