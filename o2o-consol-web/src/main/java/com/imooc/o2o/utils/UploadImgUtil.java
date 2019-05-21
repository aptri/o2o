package com.imooc.o2o.utils;

import net.minidev.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

public class UploadImgUtil {
    public static String uploadImg(MultipartHttpServletRequest multiRequest, String savePath) {
        Iterator<String> fileNames = multiRequest.getFileNames();
        String inputFileName = fileNames.next();
        MultipartFile multiFile = multiRequest.getFile(inputFileName);

        String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        Random rd = new Random();
        for (int i = 0; i < 3; i++) {
            fileName += rd.nextInt(10);
        }
        String originalFilename = multiFile.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String realPath = savePath + "upload/" + fileName + suffix;
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
        return "../images/" + relativePath;
    }
}
