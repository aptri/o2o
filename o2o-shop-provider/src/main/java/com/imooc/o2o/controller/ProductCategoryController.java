package com.imooc.o2o.controller;

import com.imooc.o2o.dto.ProductCategoryDto;
import com.imooc.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/productCategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("/queryProductCategory")
    @ResponseBody
    public List<ProductCategoryDto> queryProductCategory(){
        List<ProductCategoryDto> categoryList = productCategoryService.queryProductCategory();
        return categoryList;
    }


}
