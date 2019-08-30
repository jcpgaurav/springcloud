package com.poc.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.employee.model.Employee;
import com.poc.employee.service.EmployeeService;


@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
   // to calll this service  http://localhost:8011/api/v1/empoyee/getAll
	@GetMapping(value = "/getAll")
	public List<Employee> getAll() {

		return employeeService.getAll();
	}

}
