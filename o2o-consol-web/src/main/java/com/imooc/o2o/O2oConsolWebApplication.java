package com.imooc.o2o;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class O2oConsolWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(O2oConsolWebApplication.class, args);
    }

}
