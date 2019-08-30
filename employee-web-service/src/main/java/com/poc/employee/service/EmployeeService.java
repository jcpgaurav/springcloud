package com.poc.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.employee.dao.EmployeeDao;
import com.poc.employee.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public List<Employee> getAll() {

		return employeeDao.findAll();
	}
}
