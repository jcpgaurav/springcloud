package com.poc.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.company.model.Company;

@Repository
public interface CompanyDao extends JpaRepository<Company, Long>{
	public Company findByName(String name);
}
