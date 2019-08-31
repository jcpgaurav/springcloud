package com.poc.employee.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.poc.employee.dao.EmployeeDao;
import com.poc.employee.model.Employee;
import com.poc.feignclient.CompanyServiceProxy;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Value("${use.eureka.client:false}")
	private boolean useEurekaClient;

	@Value("${use.ribbon.backed.rest.template:false}")
	private boolean useRibbonBackedRestTemplate;

	@Value("${use.feign.client:true}")
	private boolean useFeignClient;

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private CompanyServiceProxy feignProxy;
	
	@Autowired
	private RestTemplate restTemplate;

	public List<Employee> getAll() {

		return employeeDao.findAll();
	}

	public Employee getEmployee(long employeeCode) {
		Optional<Employee> employee = employeeDao.findById(employeeCode);
		return employee.get();
	}

	public String getCompanyDetails(String companyName) {

		if (useEurekaClient) {
			Application app = eurekaClient.getApplication("company-micro-service");
			List<InstanceInfo> instances = app.getInstances();
			// http://localhost:8011/api/v1/employee/get/employee/10001
			// porobelm is this approch is its only get one company employee instanses. load
			// balancing will now work here .
			String serviceUri = String.format("%sapi/v1/company/get/{companyName}", instances.get(0).getHomePageUrl()); // http://localhost:7101/

			RestTemplate restTemplate = new RestTemplate();
			Map<String, String> urlPathVariables = new HashMap<>();
			urlPathVariables.put("companyName", companyName);

			ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceUri, String.class,
					urlPathVariables);
			String companyAdress = responseEntity.getBody();
			return companyAdress;
		} else if (useRibbonBackedRestTemplate) {
			Map<String, String> urlPathVariables = new HashMap<>();
			urlPathVariables.put("companyName", companyName);
			ResponseEntity<String> responseEntity = restTemplate
					.getForEntity("http://company-micro-service/api/v1/company/get/{companyName}", String.class, urlPathVariables);
			String companyAdressress = responseEntity.getBody();
			return companyAdressress;
		} else if (useFeignClient) {
			System.out.println("using feign...........");
			String companyAdressress = feignProxy.getCompanyDetails(companyName);
			return companyAdressress;
		}
		return "Default";
	}

}
