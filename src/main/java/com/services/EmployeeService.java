package com.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Employee;

@Service
public class EmployeeService {

	RestTemplate restTemplate = new RestTemplate();

	String resourceURL = "http://localhost:8082/IMCSRestWebServices/employee";

	public Employee getEmployee(int empNo) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "" + empNo);
		UriTemplate builder = new UriTemplate(resourceURL + "/{id}");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<String> employeeResponse = restTemplate.exchange(builder.expand(params), HttpMethod.GET, entity,
				String.class);
		Employee e = new Employee();
		if (employeeResponse != null) {
			try {
				e = mapper.readValue(employeeResponse.getBody(), Employee.class);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return e;

	}
	
	public List<Employee> getAllEmployees(int deptNo){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "" + deptNo);
		UriTemplate builder = new UriTemplate(resourceURL + "/{id}");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<String> employeeResponse = restTemplate.exchange(builder.expand(params), HttpMethod.GET, entity,
				String.class);
		List<Employee> emp = new ArrayList<>();
		if (employeeResponse != null) {
			try {
				emp = (List<Employee>) mapper.readValue(employeeResponse.getBody(), List.class);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return emp;
		
		
		
	}

	public void delete(int empNo) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "" + empNo);
		UriTemplate builder = new UriTemplate(resourceURL + "/{id}");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		restTemplate.exchange(builder.expand(params), HttpMethod.DELETE, entity, String.class);

	}

	public void createEmployee(Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(resourceURL);
		HttpEntity<Employee> entity = new HttpEntity<>(employee, headers);
		restTemplate.postForEntity(builder.build().toUri(), entity, Employee.class);

	}

	public void update(Employee emp) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "" + emp.getNumber());
		UriTemplate builder = new UriTemplate(resourceURL + "/{id}");
		HttpEntity<?> entity = new HttpEntity<>(emp, headers);
		ResponseEntity<String> employeeResponse = restTemplate.exchange(builder.expand(params), HttpMethod.PUT, entity,
				String.class);
		

	}

}
