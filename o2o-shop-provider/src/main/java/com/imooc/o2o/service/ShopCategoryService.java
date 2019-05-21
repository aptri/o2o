package com.imooc.o2o.service;

import com.imooc.o2o.dto.ShopCategoryDto;

import java.util.List;

public interface ShopCategoryService {
    List<ShopCategoryDto> queryShopCategory();
    List<ShopCategoryDto> queryCategoryNoParent();
    List<ShopCategoryDto> queryCategoryParentNotNull();
    ShopCategoryDto queryCategoryById(Integer categoryId);
    int insertShopCategory(ShopCategoryDto category);
}
