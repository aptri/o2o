package com.imooc.o2o.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcWebConfiguration extends WebMvcConfigurerAdapter {

    @Value("${upload_path_url}")
    private String upload_path_url;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (upload_path_url.equals("") || upload_path_url.equals("${upload_path_url}")) {
            String imagesPath = MvcWebConfiguration.class.getClassLoader().getResource("").getPath();
            if (imagesPath.indexOf(".jar") > 0) {
                imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
            } else if (imagesPath.indexOf("classes") > 0) {
                imagesPath = "file:" + imagesPath.substring(0, imagesPath.indexOf("classes"));
            }
            imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/")) + "/images/";
            upload_path_url = imagesPath;
        }
        registry.addResourceHandler("/images/**").addResourceLocations(upload_path_url);

        if (!registry.hasMappingForPattern("/static/**")) {
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        }
        super.addResourceHandlers(registry);
    }
}
