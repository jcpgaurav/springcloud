package com.poc.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.company.model.Company;
import com.poc.company.service.CompanyService;

@RestController
@RequestMapping("api/v1/company")
public class CompanyController {

	@Autowired
	private CompanyService employeeService;

	// to calll this service http://localhost:8012/api/v1/company/get/HP
	@GetMapping(value = "/get/{name}")
	public Company getCompanyDetails(@PathVariable String name) {

		return employeeService.getFindByName(name);
	}

	// to calll this service http://localhost:8012/api/v1/company/getAll
	@GetMapping(value = "/getAll")
	public List<Company> getAll() {

		return employeeService.getAll();
	}
}
