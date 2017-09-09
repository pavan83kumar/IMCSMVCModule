package com.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Department;

@Service
public class DepartmentService {

	RestTemplate restTemplate = new RestTemplate();

	String resourceURL = "http://localhost:8082/IMCSRestWebServices/department";

	public Department getDepartment(int deptNo) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "" + deptNo);
		UriTemplate builder = new UriTemplate(resourceURL + "/{id}");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<String> deptResponse = restTemplate.exchange(builder.expand(params), HttpMethod.GET, entity,
				String.class);
		Department dept = new Department();
		if (deptResponse != null) {
			try {
				dept = mapper.readValue(deptResponse.getBody(), Department.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return dept;
	}
}
