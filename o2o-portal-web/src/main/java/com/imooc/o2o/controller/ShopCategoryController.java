package com.imooc.o2o.controller;

import com.imooc.o2o.configuration.WebClientRestTemplate;
import com.imooc.o2o.dto.ShopCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/shopCategory")
public class ShopCategoryController {
    @Autowired
    private WebClientRestTemplate webClientRestTemplate;

    @GetMapping("/queryShopCategory")
    public ModelAndView queryShopCategory() {
        ModelAndView mv =new ModelAndView();
        List<ShopCategoryDto> shopCategoryList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shopCategory/queryShopCategory", List.class);
        mv.addObject("shopCategoryList", shopCategoryList);
        mv.setViewName("view/category/categoryList");
        return mv;
    }
    @GetMapping("/queryCategoryNoParent")
    public String queryCategoryNoParent(Model model) {
        List<ShopCategoryDto> shopCategoryList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shopCategory/queryCategoryNoParent", List.class);
        model.addAttribute("shopCategoryList", shopCategoryList);
        return "success";
    }
    @GetMapping("/queryCategoryParentNotNull")
    public String queryCategoryParentNotNull(Model model) {
        List<ShopCategoryDto> shopCategoryList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shopCategory/queryCategoryParentNotNull", List.class);
        model.addAttribute("shopCategoryList", shopCategoryList);
        return "view/category/categoryList";
    }
}
