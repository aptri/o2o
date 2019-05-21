package com.imooc.o2o.dao;

import com.imooc.o2o.dto.ProductCategoryDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductCategoryDao {
    List<ProductCategoryDto> queryProductCategory();
}
