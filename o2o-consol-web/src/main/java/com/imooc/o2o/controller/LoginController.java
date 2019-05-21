package com.imooc.o2o.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "view/login/login";
    }

    @RequestMapping("/toIndex")
    public String toTemp() {
        return "view/shop/shopMenu";
    }

}
