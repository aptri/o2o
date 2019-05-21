package com.imooc.o2o;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class O2oEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(O2oEurekaServerApplication.class, args);
    }

}
