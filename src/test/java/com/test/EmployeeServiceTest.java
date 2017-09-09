package com.test;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bootApp.App;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.models.Employee;
import com.services.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@WebAppConfiguration
public class EmployeeServiceTest {

	@Autowired
	EmployeeService service;

	@Test
	public void getData() throws JsonParseException, JsonMappingException, IOException {
		
		Employee emp = service.getEmployee(103);
		assert (emp != null);
		assert (emp.getDeptNumber() == 3);
		//System.out.println(service.getAllEmployees(1).toString());

	}

	@Test
	public void deleteTest() throws JsonParseException, JsonMappingException, IOException {

		service.delete(126);
	}
	
	

}
