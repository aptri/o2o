package com.imooc.o2o.dao;

import com.imooc.o2o.dto.ShopCategoryDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopCategoryDao {
    List<ShopCategoryDto> queryShopCategory();
    List<ShopCategoryDto> queryCategoryNoParent();
    List<ShopCategoryDto> queryCategoryParentNotNull();
    ShopCategoryDto queryCategoryById(Integer categoryId);
    int insertShopCategory(ShopCategoryDto category);
}
