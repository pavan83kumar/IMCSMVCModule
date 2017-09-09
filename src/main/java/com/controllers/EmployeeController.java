package com.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.models.Employee;
import com.services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String employeePage() {
		return "employee";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage() {
		return "homepage";
	}

	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
	public ModelAndView getEmployee(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView("displayemployee");
		modelAndView.addObject("empObject", service.getEmployee(id));
		return modelAndView;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@RequestParam("id") int id) {
		service.delete(id);
		ModelAndView modelAndView = new ModelAndView("employee");
		modelAndView.addObject("msg", "Employee Deleted successfully!");
		return modelAndView;

	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateEmp(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView("update");
		modelAndView.addObject("empObject", service.getEmployee(id));
		return modelAndView;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute Employee empl) {
		service.update(empl);
		ModelAndView model = new ModelAndView("employee");
		model.addObject("msg", "Employee Updated successfully!");
		return model;
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("addForm") Employee employee) {
		employee.setNumber(0);
		System.out.println("entered into addEmployee method " + employee);
		service.createEmployee(employee);
		ModelAndView modelAndView = new ModelAndView("employee");
		modelAndView.addObject("msg", "User ID added successfully");
		return modelAndView;

	}

	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
	public ModelAndView getAllEmployees(@RequestParam("deptNo") int deptNo) {
		ModelAndView modelAndView = new ModelAndView("displayemployeesbydeptId");
		List<Employee> empList = new ArrayList<>();
		empList = service.getAllEmployees(deptNo);
		if (empList.size() != 0) {
			modelAndView.addObject("empObject", empList);
			return modelAndView;
		} else {
			modelAndView.addObject("msg", "The given department Number has no employees");
			return modelAndView;
		}
	}

}
