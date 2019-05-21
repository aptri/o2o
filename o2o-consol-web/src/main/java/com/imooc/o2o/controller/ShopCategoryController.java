package com.imooc.o2o.controller;

import com.imooc.o2o.configuration.WebClientRestTemplate;
import com.imooc.o2o.dto.ShopCategoryDto;
import com.imooc.o2o.utils.KaptchaCodeUtil;
import net.minidev.json.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @RequestMapping(value = "/toCategoryAdd",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView toCategoryAdd() {
        ModelAndView mv =new ModelAndView();
        List<ShopCategoryDto> shopCategoryList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shopCategory/queryCategoryNoParent", List.class);
        mv.addObject("categoryParentList",shopCategoryList);
        mv.setViewName("view/category/categoryAdd");
        return mv;
    }
    @RequestMapping("/toCategoryEdit")
    public String toCategoryEdit(String shopCategoryId,Model model) {
        ShopCategoryDto shopCategory = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shopCategory/queryCategoryById?categoryId="+shopCategoryId, ShopCategoryDto.class);
        List<ShopCategoryDto> shopCategoryList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shopCategory/queryCategoryNoParent", List.class);
        model.addAttribute("categoryParentList",shopCategoryList);
        model.addAttribute("categoryDto", shopCategory);
        return "view/category/categoryEdit";
    }
    @RequestMapping("/categorySave")
    @ResponseBody
    public String categorySave(ShopCategoryDto dto, HttpServletRequest request) {
        if (!KaptchaCodeUtil.checkKaptchaInCode(request)) {
            return "failure";
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime=sdf.format(new Date());
        dto.setCreateTime(nowTime);
        dto.setLastEditTime(nowTime);
        String jsonCategory=JSONValue.toJSONString(dto);
        String result = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shopCategory/insertShopCategory?jsonCategory="+jsonCategory, String.class);

        return result;
    }
    @RequestMapping("/categoryUpdate")
    public String categoryUpdate(ShopCategoryDto dto, HttpServletRequest request) {
        if (!KaptchaCodeUtil.checkKaptchaInCode(request)) {
            return "failure";
        }
        String jsonCategory=JSONValue.toJSONString(dto);
        String result = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shopCategory/categoryUpdate?jsonCategory="+jsonCategory, String.class);

        return result;
    }
}
