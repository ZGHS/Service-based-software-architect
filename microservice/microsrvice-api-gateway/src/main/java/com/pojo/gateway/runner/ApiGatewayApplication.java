package com.pojo.gateway.runner;


import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@EnableSwagger2
@EnableZuulProxy
@SpringBootApplication
@ComponentScan(basePackages = "com.pojo.gateway.filter")
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    /**
     * 配置Swagger
     */
    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider {
        @Override
        public List<SwaggerResource> get() {
            List resource = new ArrayList<>();
            //name可以随便写，location前缀要与zuul配置的path一致。zuul开了token验证,要加上token,否则不用加?token=1
            resource.add(swaggerResource("microservice-user", "/order-service/v2/api-docs", "2.0"));
            resource.add(swaggerResource("microservice-ticket", "/item-service/v2/api-docs", "2.0"));
            resource.add(swaggerResource("microservice-payment", "/payment-service/v2/api-docs", "2.0"));
            return resource;
        }

        //name可以随便写，location前缀要与zuul配置的path一致
        private SwaggerResource swaggerResource(String name, String location, String version) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }
}
