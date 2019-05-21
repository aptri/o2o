package com.imooc.o2o.controller;

import com.imooc.o2o.configuration.WebClientRestTemplate;
import com.imooc.o2o.dto.AreaDto;
import com.imooc.o2o.dto.ProductDto;
import com.imooc.o2o.dto.ShopCategoryDto;
import com.imooc.o2o.dto.ShopDto;
import net.minidev.json.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private WebClientRestTemplate webClientRestTemplate;
    @Value("${upload_path_url}")
    private String upload_path_url;

    @RequestMapping(value = "/toShopList", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView toShopList() {
        ModelAndView mv = new ModelAndView();
        List<ShopCategoryDto> shopCategoryList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shopCategory/queryShopCategory", List.class);
        List<AreaDto> areaList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/area/queryArea", List.class);
        List<ShopDto> shopList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shop/queryShopList", List.class);
        mv.addObject("shopList", shopList);
        mv.addObject("shopCategoryList", shopCategoryList);
        mv.addObject("areaList", areaList);
        mv.setViewName("view/shop/shopList");
        return mv;
    }

    @RequestMapping(value = "/queryShopByCondition", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView queryShopByCondition(ShopDto shopDto) {
        String shopStr = JSONValue.toJSONString(shopDto);

        ModelAndView mv = new ModelAndView();
        List<ShopCategoryDto> shopCategoryList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shopCategory/queryShopCategory", List.class);
        List<ShopDto> shopList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shop/queryShopByCondition?shopStr=" + shopStr, List.class);
        List<AreaDto> areaList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/area/queryArea", List.class);
        mv.addObject("shopList", shopList);
        mv.addObject("shopCategoryList", shopCategoryList);
        mv.addObject("areaList", areaList);
        mv.setViewName("view/shop/shopList");
        return mv;
    }
    @RequestMapping(value = "/queryShopByCategoryId", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView queryShopByCategoryId(String categoryId) {
        ModelAndView mv = new ModelAndView();
        ShopCategoryDto shopCategory = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shopCategory/queryCategoryById?categoryId="+categoryId, ShopCategoryDto.class);
        List<ShopDto> shopList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shop/queryShopByCategoryId?categoryId=" + categoryId, List.class);
        List<AreaDto> areaList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/area/queryArea", List.class);
        mv.addObject("areaList", areaList);
        mv.addObject("shopList", shopList);
        mv.addObject("shopCategory", shopCategory);
        mv.setViewName("view/shop/shopList");
        return mv;
    }

    @RequestMapping(value = "/shopDetail", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ModelAndView shopDetail(String shopId) {
        ModelAndView mv = new ModelAndView();
        List<ShopCategoryDto> shopCategoryList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shopCategory/queryShopCategory", List.class);
        List<AreaDto> areaList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/area/queryArea", List.class);
        ShopDto shop = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shop/editShop?shopId=" + shopId, ShopDto.class);
        List<ProductDto> productList=webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/product/queryProductByShopId?shopId="+shopId, List.class);
        mv.addObject("shop", shop);
        mv.addObject("shopCategoryList", shopCategoryList);
        mv.addObject("areaList", areaList);
        mv.addObject("productList",productList);
        mv.setViewName("view/shop/shopDetail");
        return mv;
    }
}
