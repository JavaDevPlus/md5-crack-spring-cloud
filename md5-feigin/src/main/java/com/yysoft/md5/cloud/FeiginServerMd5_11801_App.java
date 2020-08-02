package com.yysoft.md5.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })

public class FeiginServerMd5_11801_App {

	public static void main(String[] args) {
		SpringApplication.run(FeiginServerMd5_11801_App.class, args);
	}

	@Bean
	@LoadBalanced // 开启Ribbon负载均衡
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
