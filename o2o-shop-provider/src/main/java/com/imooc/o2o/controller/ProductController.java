package com.imooc.o2o.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.o2o.dto.ProductDto;
import com.imooc.o2o.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @RequestMapping("/queryProduct")
    public List<ProductDto> queryProduct(){
        List<ProductDto> productList = productService.queryProduct();
        return productList;
    }

    @RequestMapping("/queryProductByCondition")
    public List<ProductDto> queryProductByCondition(String jsonProduct){
        ObjectMapper mapper=new ObjectMapper();
        ProductDto dto=new ProductDto();
        try {
            dto=mapper.readValue(jsonProduct,ProductDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<ProductDto> productList = productService.queryProductByCondition(dto);
        return productList;
    }

    @RequestMapping("/queryProductByShopId")
    @ResponseBody
    public List<ProductDto> queryProductByShopId(String shopId){
        List<ProductDto> productList = productService.queryProductByShopId(Integer.valueOf(shopId));
        return productList;
    }

    @RequestMapping("/queryProductByProductId")
    @ResponseBody
    public ProductDto queryProductByProductId(String productId){
        ProductDto product = productService.queryProductByProductId(Integer.valueOf(productId));
        return product;
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(String jsonProduct){
        ObjectMapper mapper=new ObjectMapper();
        ProductDto dto=new ProductDto();
        try {
            dto=mapper.readValue(jsonProduct,ProductDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int effectNum = productService.updateProduct(dto);
        if(effectNum==1){
            return "success";
        }
        return "failure";
    }
    @RequestMapping("/insertProduct")
    @ResponseBody
    public String insertProduct(String jsonProduct){
        ObjectMapper mapper=new ObjectMapper();
        ProductDto dto=new ProductDto();
        try {
            dto=mapper.readValue(jsonProduct,ProductDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dto.setPoint(2);
        int effectNum = productService.insertProduct(dto);
        if(effectNum==1){
            return "success";
        }
        return "failure";
    }
}
