package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.ShopCategoryDao;
import com.imooc.o2o.dto.ShopCategoryDto;
import com.imooc.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategoryDto> queryShopCategory() {
        return shopCategoryDao.queryShopCategory();
    }

    @Override
    public List<ShopCategoryDto> queryCategoryNoParent() {
        return shopCategoryDao.queryCategoryNoParent();
    }

    @Override
    public List<ShopCategoryDto> queryCategoryParentNotNull() {
        return shopCategoryDao.queryCategoryParentNotNull();
    }

    @Override
    public ShopCategoryDto queryCategoryById(Integer categoryId) {
        return shopCategoryDao.queryCategoryById(categoryId);
    }

    @Override
    public int insertShopCategory(ShopCategoryDto category) {
        return shopCategoryDao.insertShopCategory(category);
    }
}
