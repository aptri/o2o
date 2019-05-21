package com.imooc.o2o.controller;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Value("${file_path}")
    private String upload_path_url;

    @RequestMapping(value = "/uploadPic", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String uploadFile(HttpServletRequest request) {
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        Iterator<String> fileNames = multiRequest.getFileNames();
        String inputFileName = fileNames.next();
        MultipartFile multiFile = multiRequest.getFile(inputFileName);
//        byte[] fileByte = new byte[Integer.valueOf(String.valueOf(multiFile.getSize()))];
//        try {
//            fileByte = multiFile.getBytes();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        Random rd = new Random();
        for (int i = 0; i < 3; i++) {
            fileName += rd.nextInt(10);
        }
        String originalFilename = multiFile.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String realPath = upload_path_url + fileName + suffix;
        String relativePath = fileName + suffix;
        File file = new File(realPath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            multiFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject json = new JSONObject();
        json.appendField("realPath", "../images/" + relativePath);
        json.appendField("relativePath", "../images/" + relativePath);
        return json.toJSONString();
    }
}
