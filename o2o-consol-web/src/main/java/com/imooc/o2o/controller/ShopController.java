package com.imooc.o2o.controller;

import com.imooc.o2o.configuration.WebClientRestTemplate;
import com.imooc.o2o.dto.ShopDto;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.utils.KaptchaCodeUtil;
import net.minidev.json.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
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
//        List<ShopCategory> shopCategoryList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shopCategory/queryShopCategory", List.class);
//        List<Area> areaList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/area/queryArea", List.class);
        List<Shop> shopList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shop/queryShopList", List.class);
        mv.addObject("shopList", shopList);
//        mv.addObject("shopCategoryList", shopCategoryList);
//        mv.addObject("areaList", areaList);
        mv.setViewName("view/shop/shopList");
        return mv;
    }

    @RequestMapping(value = "/queryShop", method = {RequestMethod.GET, RequestMethod.POST})
    public String queryShopByCondition(ShopDto shopDto, Model model) {
        String shopStr = JSONValue.toJSONString(shopDto);
        List<Shop> shopList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shop/queryShopByCondition?shopStr=" + shopStr, List.class);
        model.addAttribute("shopList", shopList);
        return "success";
    }

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value = "/shopEdit", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ModelAndView shopEdit(String shopId) {
        ModelAndView mv = new ModelAndView();
        List<ShopCategory> shopCategoryList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shopCategory/queryShopCategory", List.class);
        List<Area> areaList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/area/queryArea", List.class);
        ShopDto shop = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shop/editShop?shopId=" + shopId, ShopDto.class);
        mv.addObject("shop", shop);
        mv.addObject("shopCategoryList", shopCategoryList);
        mv.addObject("areaList", areaList);
        mv.setViewName("view/shop/shopEdit");
        return mv;
    }

    @RequestMapping("/shopDelete")
    public String shopDelete(String shopId) {
        String result = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shop/delShop?shopId=" + shopId, String.class);
        return result;
    }

    @RequestMapping(value = "/toShopAdd", method = {RequestMethod.GET, RequestMethod.POST})
    public String toShopAdd(Model model) {
        List<ShopCategory> shopCategoryList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shopCategory/queryShopCategory", List.class);
        model.addAttribute("shopCategoryList", shopCategoryList);
        List<Area> areaList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/area/queryArea", List.class);
        model.addAttribute("areaList", areaList);
        return "view/shop/shopAdd";
    }

    @RequestMapping(value = "/shopSave", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String shopSave(ShopDto dto, HttpServletRequest request) {
        if (!KaptchaCodeUtil.checkKaptchaInCode(request)) {
            return "failure";
        }
        dto.setUserId(23);
        dto.setAdvice("1");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDate = sdf.format(new Date());
        dto.setCreateTime(nowDate);
        dto.setLastEditTime(nowDate);
        dto.setEnableStatus(1);
        dto.setPriority(1);
        String jsonShop = JSONValue.toJSONString(dto);
        String result = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shop/insertShop?jsonShop=" + jsonShop, String.class);
        return result;
    }

    @RequestMapping(value = "/shopUpdate", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String shopUpdate(ShopDto dto, HttpServletRequest request) {
        if (!KaptchaCodeUtil.checkKaptchaInCode(request)) {
            return "failure";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDate = sdf.format(new Date());
        dto.setLastEditTime(nowDate);
        String jsonShop = JSONValue.toJSONString(dto);
        String result = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/shop/shopUpdate?jsonShop=" + jsonShop, String.class);
        return result;
    }
}
