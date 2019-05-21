package com.imooc.o2o.dao;

import com.imooc.o2o.dto.ShopDto;
import com.imooc.o2o.entity.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopDao {
    int insertShop(ShopDto shopDto);

    List<ShopDto> queryShopList();
    List<ShopDto> queryShopByCategoryId(@Param("categoryId") Integer categoryId);
    ShopDto queryShopById(@Param("shopId") Integer shopId);
}
