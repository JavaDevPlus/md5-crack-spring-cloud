package com.yysoft.md5.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//表明是EurekaServer 接受其他服务注册
@EnableEurekaServer
public class EurekaServerMd5_7001_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMd5_7001_App.class,args);
    }
}
