package com.imooc.o2o;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class O2oShopProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(O2oShopProviderApplication.class, args);
    }

}
