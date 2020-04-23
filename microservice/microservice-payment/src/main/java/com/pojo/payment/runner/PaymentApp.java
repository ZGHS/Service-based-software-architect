package com.pojo.payment.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Evan
 */
//申明这是一个Spring Boot项目
@EnableSwagger2
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages ="com.pojo.payment.feign")
@ComponentScan(basePackages = {"com.pojo.payment.controller", "com.pojo.payment.service"})
public class PaymentApp {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApp.class, args);
    }
}
