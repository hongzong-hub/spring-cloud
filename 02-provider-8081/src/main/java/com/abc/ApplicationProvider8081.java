package com.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient //仅仅局限于注册中心是eureka
//@EnableDiscoveryClient//注册中心可以是任何类型
@SpringBootApplication
public class ApplicationProvider8081 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationProvider8081.class, args);
    }

}
