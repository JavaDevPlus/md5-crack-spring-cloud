package com.yysoft.md5.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ZipkinApplication_9000 {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinApplication_9000.class, args);
	}

}
