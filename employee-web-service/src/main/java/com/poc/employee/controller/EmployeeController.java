package com.poc.employee.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.employee.model.Employee;
import com.poc.employee.model.EmployeeVo;
import com.poc.employee.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("api/v1/employee")
@Api(value = "Employee Management System", description = "Operations pertaining to employee in Employee Management System")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// to calll this service http://localhost:8081/api/v1/employee/getAll
	@ApiOperation(value = "View a list of available employees")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@GetMapping(value = "/getAll")
	public List<Employee> getAll() {

		return employeeService.getAll();
	}

	// to calll this service http://localhost:8081/api/v1/employee/getAll
	@ApiOperation(value = "View a  employee details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Employee"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	// To call its http://localhost:8011/api/v1/employee/get/employee/10001
	
	@GetMapping(value = "/get/employee/{employeeCode}")
	public EmployeeVo getEmployee(@PathVariable String employeeCode) {
		System.out.println(System.currentTimeMillis());
		Employee employee = employeeService.getEmployee(Long.parseLong(employeeCode));
		String companyAddress = employeeService.getCompanyDetails(employee.getCompany());
		EmployeeVo  employeeVo  = new EmployeeVo();
		BeanUtils.copyProperties(employee, employeeVo);
		employeeVo.setCompanyAddress(companyAddress);
		return employeeVo;
	}
}
