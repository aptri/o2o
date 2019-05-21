package com.imooc.o2o.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.o2o.dto.ShopDto;

import com.imooc.o2o.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @GetMapping("/queryShopList")
    public List<ShopDto> queryShopList() {
        List<ShopDto> list = shopService.queryShopList();
        return list;
    }

    @GetMapping("/queryShopByCategoryId")
    public List<ShopDto> queryShopByCategoryId(String categoryId) {
        List<ShopDto> list = shopService.queryShopByCategoryId(Integer.valueOf(categoryId));
        return list;
    }

    @RequestMapping(value = "/insertShop", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String insertShop(String jsonShop) {
        ObjectMapper mapper = new ObjectMapper();
        ShopDto dto = new ShopDto();
        try {
            dto = mapper.readValue(jsonShop, ShopDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int effectNum = shopService.insertShop(dto);
        if (effectNum == 1) {
            return "success";
        }
        return "failure";
    }

    @GetMapping("/editShop")
    public ShopDto editShop(String shopId) {
        ShopDto shop = shopService.queryShopById(Integer.valueOf(shopId));
        return shop;
    }

    @GetMapping("/delShop")
    public String delShop(String shopId) {

        return "success";
    }
}
