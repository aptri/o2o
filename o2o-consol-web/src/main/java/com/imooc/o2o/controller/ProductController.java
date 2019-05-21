package com.imooc.o2o.controller;

import com.imooc.o2o.configuration.WebClientRestTemplate;
import com.imooc.o2o.dto.ProductCategoryDto;
import com.imooc.o2o.dto.ProductDto;
import com.imooc.o2o.dto.ShopDto;
import com.imooc.o2o.utils.KaptchaCodeUtil;
import net.minidev.json.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private WebClientRestTemplate webClientRestTemplate;

    @RequestMapping("/toShopList")
    public String toShopList(Model model){
        List<ShopDto> shopList=webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shop/queryShopList", List.class);
        model.addAttribute("shopList",shopList);
        return "view/product/shopList";
    }
    @RequestMapping("/shopDetail")
    public String queryProductByShopId(String shopId,Model model){
        ShopDto shop = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shop/editShop?shopId=" + shopId, ShopDto.class);
        List<ProductDto> productList=webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/product/queryProductByShopId?shopId="+shopId, List.class);
        model.addAttribute("productList",productList);
        model.addAttribute("shop",shop);
        return "view/product/shopDetail";
    }
    @RequestMapping("/productEdit")
    public String productEdit(String productId,Model model){
        List<ProductCategoryDto> productCategoryList =webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/productCategory/queryProductCategory", List.class);
        model.addAttribute("productCategoryList",productCategoryList);
        ProductDto product=webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/product/queryProductByProductId?productId="+productId, ProductDto.class);
        model.addAttribute("product",product);
        return "view/product/productEdit";
    }
    @RequestMapping("/productAdd")
    public String productAdd(String shopId,Model model){
        List<ProductCategoryDto> productCategoryList =webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/productCategory/queryProductCategory", List.class);
        model.addAttribute("productCategoryList",productCategoryList);
        model.addAttribute("shopId",shopId);
        return "view/product/productAdd";
    }

    @RequestMapping("/productSave")
    @ResponseBody
    public String productSave(ProductDto dto, HttpServletRequest request) {
        if (!KaptchaCodeUtil.checkKaptchaInCode(request)) {
            return "failure";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDate = sdf.format(new Date());
        dto.setCreateTime(nowDate);
        dto.setLastEditTime(nowDate);
        String jsonProduct = JSONValue.toJSONString(dto);
        String result = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/product/insertProduct?jsonProduct=" + jsonProduct, String.class);
        return result;
    }

    @RequestMapping("/productUpdate")
    public String productUpdate(ProductDto dto, HttpServletRequest request) {
        if (!KaptchaCodeUtil.checkKaptchaInCode(request)) {
            return "failure";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDate = sdf.format(new Date());
        dto.setLastEditTime(nowDate);
        String jsonProduct = JSONValue.toJSONString(dto);
        String result = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/product/productUpdate?jsonProduct=" + jsonProduct, String.class);
        return result;
    }
}
