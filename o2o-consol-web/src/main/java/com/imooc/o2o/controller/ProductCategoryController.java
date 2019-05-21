package com.imooc.o2o.controller;

import com.imooc.o2o.configuration.WebClientRestTemplate;
import com.imooc.o2o.dto.ProductCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/productCategory")
public class ProductCategoryController {

    @Autowired
    private WebClientRestTemplate webClientRestTemplate;

    public String queryProductCategory(){
       List<ProductCategoryDto> productCategoryList =webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/productCategory/queryProductCategory", List.class);
       return "view/product/productCategory";
    }
}
