package com.imooc.o2o.controller;

import com.imooc.o2o.configuration.WebClientRestTemplate;
import com.imooc.o2o.dto.HeadLineDto;
import com.imooc.o2o.utils.KaptchaCodeUtil;
import net.minidev.json.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/headline")
public class HeadLineController {
    @Autowired
    private WebClientRestTemplate webClientRestTemplate;

    @GetMapping("/queryHeadLine")
    public ModelAndView queryHeadLine() {
        ModelAndView mv =new ModelAndView();
        List<HeadLineDto> headLineList = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/headLine/queryHeadLine", List.class);
        mv.addObject("headLineList", headLineList);
        mv.setViewName("view/headline/headLineList");
        return mv;
    }
    @RequestMapping(value = "/toHeadLineAdd",method = {RequestMethod.GET,RequestMethod.POST})
    public String toHeadLineAdd() {

        return "view/headline/headLineAdd";
    }
    @RequestMapping("/toHeadLineEdit")
    public String toHeadLineEdit(String lineId,Model model) {
        HeadLineDto headLineDto = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/headLine/queryHeadLineById?lineId="+lineId, HeadLineDto.class);
        model.addAttribute("headLineDto", headLineDto);
        return "view/headline/headLineEdit";
    }
    @RequestMapping("/headLineSave")
    @ResponseBody
    public String headLineSave(HeadLineDto dto, HttpServletRequest request) {
        if (!KaptchaCodeUtil.checkKaptchaInCode(request)) {
            return "failure";
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime=sdf.format(new Date());
        dto.setCreateTime(nowTime);
        dto.setLastEditTime(nowTime);
        String jsonLine=JSONValue.toJSONString(dto);
        String result = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/headLine/insertHeadLine?jsonLine="+jsonLine, String.class);

        return result;
    }
    @RequestMapping("/headLineUpdate")
    @ResponseBody
    public String headLineUpdate(HeadLineDto dto, HttpServletRequest request) {
        if (!KaptchaCodeUtil.checkKaptchaInCode(request)) {
            return "failure";
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime=sdf.format(new Date());
        dto.setLastEditTime(nowTime);
        String jsonLine=JSONValue.toJSONString(dto);
        String result = webClientRestTemplate.getRestTemplate().getForObject("http://o2o-view.shop-privider/headLine/updateHeadLine?jsonLine="+jsonLine, String.class);

        return result;
    }
}
