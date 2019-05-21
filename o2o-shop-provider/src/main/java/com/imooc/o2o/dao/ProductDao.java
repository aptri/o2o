package com.imooc.o2o.dao;

import com.imooc.o2o.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductDao {
    List<ProductDto> queryProduct();
    List<ProductDto> queryProductByCondition(ProductDto product);
    List<ProductDto> queryProductByShopId(@Param("shopId") Integer shopId);
    ProductDto queryProductByProductId(@Param("productId") Integer productId);
    int updateProduct(ProductDto product);
    int insertProduct(ProductDto product);
}
