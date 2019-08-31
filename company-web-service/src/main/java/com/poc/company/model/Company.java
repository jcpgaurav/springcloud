package com.poc.company.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity

public class Company {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String address ;
	
	@Transient
	private long port;
	

}
