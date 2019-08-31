package com.poc.employee.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class EmployeeVo {
	
	private Long id;
	private String name;
	private String company ;
	private String companyAddress ;
	

}
