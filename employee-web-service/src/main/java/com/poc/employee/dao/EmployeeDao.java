package com.poc.employee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.employee.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long>{
	public List<Employee> findByName(String name);
}
