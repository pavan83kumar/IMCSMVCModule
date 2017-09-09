package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bootApp.App;
import com.models.Department;
import com.services.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@WebAppConfiguration
public class DepartmentServiceTest {
	
	@Autowired
	DepartmentService service;
	
	@Test
	public void getData(){
		Department dept = service.getDepartment(1);
		
		assert(dept!=null);
		assert(dept.getDeptName().equals("HR"));
	}

}
