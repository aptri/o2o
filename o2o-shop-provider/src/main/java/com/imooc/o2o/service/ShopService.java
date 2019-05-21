package com.imooc.o2o.service;

import com.imooc.o2o.dto.ShopDto;
import com.imooc.o2o.entity.Shop;

import java.util.List;

public interface ShopService {
    int insertShop(ShopDto shopDto);

    List<ShopDto> queryShopList();
    List<ShopDto> queryShopByCategoryId(Integer categoryId);
    ShopDto queryShopById(Integer shopId);
}
