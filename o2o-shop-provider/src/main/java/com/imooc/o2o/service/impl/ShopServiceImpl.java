package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.ShopDao;
import com.imooc.o2o.dto.ShopDto;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Override
    public int insertShop(ShopDto shopDto) {

        return shopDao.insertShop(shopDto);
    }

    @Override
    public List<ShopDto> queryShopList() {
        return shopDao.queryShopList();
    }

    @Override
    public List<ShopDto> queryShopByCategoryId(Integer categoryId) {
        return shopDao.queryShopByCategoryId(categoryId);
    }

    @Override
    public ShopDto queryShopById(Integer shopId) {
        return shopDao.queryShopById(shopId);
    }
}
