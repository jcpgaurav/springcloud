package com.operative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2 
public class SpringZuulApiGateway {

	public static void main(String[] args) {
		SpringApplication.run(SpringZuulApiGateway.class, args);
	}
}
