package com.imooc.o2o.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/console")
public class ConsolController {

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "view/index";
    }
}
