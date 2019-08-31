package com.poc.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket employeeApi() {

		return new Docket(DocumentationType.SWAGGER_2)

				.select().apis(RequestHandlerSelectors.basePackage("com.poc.employee.controller")).paths(regex("/.*"))
				.build().apiInfo(apiEndPointsInfo());

	}

	private ApiInfo apiEndPointsInfo() {

		return new ApiInfoBuilder().title("Spring Boot REST API").description("Employee Management REST API")
				.contact(new Contact("Gaurave", "siteUrl", "gaurav@domain.com")).license("Apache 3.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("3.0.0").build();
	}
}