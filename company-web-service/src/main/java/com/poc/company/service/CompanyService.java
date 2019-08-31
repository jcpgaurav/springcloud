package com.poc.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.poc.company.dao.CompanyDao;
import com.poc.company.model.Company;

@Service
public class CompanyService {

	@Autowired
	private CompanyDao companyDao;

	@Autowired
	private Environment environment;

	public List<Company> getAll() {

		return companyDao.findAll();
	}

	public Company getFindByName(String name) {

		long portNo = Integer.parseInt(environment.getProperty("local.server.port"));
		Company cocmpany = companyDao.findByName(name);
		cocmpany.setPort(portNo);
		return cocmpany;
	}
}
