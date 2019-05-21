package com.imooc.o2o.controller;

import com.imooc.o2o.configuration.WebClientRestTemplate;
import com.imooc.o2o.entity.PersonInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private WebClientRestTemplate webClientRestTemplate;

    @GetMapping("/queryUser")
    public ModelAndView queryUser() {
        ModelAndView mv = new ModelAndView();
        List<PersonInfo> userList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/user/queryUser", List.class);

        mv.addObject("shopList", userList);
        return mv;
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    public String register() {
        String result = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/user/register", String.class);
        return result;
    }

    @RequestMapping(value = "/toRegister", method = {RequestMethod.GET, RequestMethod.POST})
    public String toRegister() {
        return "view/user/register";
    }
}
