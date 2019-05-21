package com.imooc.o2o.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.o2o.dto.ShopCategoryDto;
import com.imooc.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/shopCategory")
public class ShopCategoryController {
    @Autowired
    private ShopCategoryService shopCategoryService;

    @GetMapping("/queryShopCategory")
    public List<ShopCategoryDto> queryShopCategory() {
        List<ShopCategoryDto> categoryList = shopCategoryService.queryShopCategory();
        return categoryList;
    }
    @GetMapping("/queryCategoryNoParent")
    public List<ShopCategoryDto> queryCategoryNoParent(Model model) {
        List<ShopCategoryDto> shopCategoryList = shopCategoryService.queryCategoryNoParent();

        return shopCategoryList;
    }
    @GetMapping("/queryCategoryParentNotNull")
    public List<ShopCategoryDto> queryCategoryParentNotNull(Model model) {
        List<ShopCategoryDto> shopCategoryList = shopCategoryService.queryCategoryParentNotNull();

        return shopCategoryList;
    }
    @RequestMapping("/queryCategoryById")
    public ShopCategoryDto queryCategoryById(String categoryId) {
        ShopCategoryDto shopCategory = shopCategoryService.queryCategoryById(Integer.valueOf(categoryId));

        return shopCategory;
    }
    @RequestMapping("/insertShopCategory")
    @ResponseBody
    public String insertShopCategory(String jsonCategory) {
        ObjectMapper mapper = new ObjectMapper();
        ShopCategoryDto dto = new ShopCategoryDto();
        try {
            dto = mapper.readValue(jsonCategory, ShopCategoryDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int effectNum = shopCategoryService.insertShopCategory(dto);
        if (effectNum == 1) {
            return "success";
        }
        return "failure";
    }
}
