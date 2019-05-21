package com.imooc.o2o.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.o2o.dto.HeadLineDto;
import com.imooc.o2o.service.HeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/headLine")
public class HeadLineController {
    @Autowired
    private HeadLineService headLineService;

    @GetMapping("/queryHeadLine")
    public List<HeadLineDto> queryShopCategory() {
        List<HeadLineDto> headLineList = headLineService.queryHeadLine();
        return headLineList;
    }

    @RequestMapping("/queryHeadLineById")
    public HeadLineDto queryHeadLineById(String lineId) {
        HeadLineDto headLine = headLineService.queryHeadLineById(Integer.valueOf(lineId));

        return headLine;
    }
    @RequestMapping("/insertHeadLine")
    @ResponseBody
    public String insertHeadLine(String jsonLine) {
        ObjectMapper mapper = new ObjectMapper();
        HeadLineDto dto = new HeadLineDto();
        try {
            dto = mapper.readValue(jsonLine, HeadLineDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int effectNum = headLineService.insertHeadLine(dto);
        if (effectNum == 1) {
            return "success";
        }
        return "failure";
    }
    @RequestMapping("/updateHeadLine")
    @ResponseBody
    public String updateHeadLine(String jsonLine) {
        ObjectMapper mapper = new ObjectMapper();
        HeadLineDto dto = new HeadLineDto();
        try {
            dto = mapper.readValue(jsonLine, HeadLineDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int effectNum = headLineService.updateHeadLine(dto);
        if (effectNum == 1) {
            return "success";
        }
        return "failure";
    }
}
