package com.imooc.o2o.controller;

import com.imooc.o2o.configuration.WebClientRestTemplate;
import com.imooc.o2o.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private WebClientRestTemplate webClientRestTemplate;

    @GetMapping("/queryArea")
    public String queryArea(Model model) {
        List<Area> areaList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/area/queryArea", List.class);

        model.addAttribute("areaList", areaList);
        return "success";
    }
}
