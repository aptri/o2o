package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.ProductDao;
import com.imooc.o2o.dto.ProductDto;
import com.imooc.o2o.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<ProductDto> queryProduct() {
        return productDao.queryProduct();
    }

    @Override
    public List<ProductDto> queryProductByCondition(ProductDto product) {
        return productDao.queryProductByCondition(product);
    }

    @Override
    public List<ProductDto> queryProductByShopId(Integer shopId) {
        return productDao.queryProductByShopId(shopId);
    }

    @Override
    public ProductDto queryProductByProductId(Integer productId) {
        return productDao.queryProductByProductId(productId);
    }

    @Override
    public int updateProduct(ProductDto product) {
        return productDao.updateProduct(product);
    }

    @Override
    public int insertProduct(ProductDto product) {
        return productDao.insertProduct(product);
    }
}
