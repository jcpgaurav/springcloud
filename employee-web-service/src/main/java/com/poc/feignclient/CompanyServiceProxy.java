package com.poc.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


//@FeignClient(name = "currency-conversion")
@FeignClient(name = "spring-cloud-api-gateway")
@RequestMapping(value = "cws/api/v1/company")
public interface CompanyServiceProxy {

	@GetMapping(value = "/get/{name}")
	public String getCompanyDetails(@PathVariable String name) ;
}
