package com.xiaolh.swagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Create by 肖橙橙
 * Date: 2020:08:04  00:34
 */
@Configuration
@SpringBootApplication // 组件扫描
@EnableScheduling
@EnableAsync
@EnableSwagger2 //@EnableSwagger2来启动swagger注解
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
