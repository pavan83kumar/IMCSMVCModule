package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.models.Department;
import com.services.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentService service;

	@RequestMapping(value="/department", method = RequestMethod.GET)
	public String departmentPage() {
		return "department";
	}

	
	@RequestMapping(value = "/getDept",method = RequestMethod.GET)
	public ModelAndView getDepartment(@RequestParam int id) {
		Department department = service.getDepartment(id);
		ModelAndView modelAndView = new ModelAndView("department");
		
		if(null != department){
			modelAndView.addObject("deptObject",department);
		}else{
			modelAndView.addObject("msg", "There is no such department with that number: "+id);
		}
		
		return modelAndView;
	}
	
	
	

}
