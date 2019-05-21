package com.imooc.o2o.controller;

import com.imooc.o2o.configuration.WebClientRestTemplate;
import com.imooc.o2o.dto.ShopCategoryDto;
import com.imooc.o2o.dto.HeadLineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/portal")
public class PortalController {

    @Autowired
    private WebClientRestTemplate webClientRestTemplate;
    @RequestMapping("/toIndex")
    public String toIndex(Model model){
       List<HeadLineDto> headLineList =webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/headLine/queryHeadLine",List.class);
       List<ShopCategoryDto> shopCategoryList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shopCategory/queryCategoryNoParent", List.class);
       model.addAttribute("shopCategoryList", shopCategoryList);
       model.addAttribute("headLineList",headLineList);
       return "view/index";
    }
}
