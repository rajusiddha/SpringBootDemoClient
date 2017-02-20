package com.nisum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.domain.Employee;
import com.nisum.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmplyeeController {
	
	/* @Value("${name}")
	private String mongoHost;*/

	@Autowired
	EmployeeService employeeService; 
	
	@RequestMapping( method=RequestMethod.GET)
	public List<Employee> getAllPersons(){
//		System.out.println("****************"+mongoHost);
		return employeeService.getAll();
	}
	
	@RequestMapping(value="/rest/oauth", method=RequestMethod.GET)
	public List<Employee> getAllPersonsAuth(){
		
		return employeeService.getAll();
	}
	
	@RequestMapping(value="/save",  method = RequestMethod.POST)
	public String SavePersons( @RequestBody Employee employee){
		employeeService.save(employee);
		return "Success";
	}
	
	@RequestMapping(value = "/update/{id}",method=RequestMethod.PUT)
	public String updatePerson( @PathVariable String id , @RequestBody Employee employee){
		employeeService.updatePerson(id,employee);
		return "Success";
	}
	
	@RequestMapping( value="/remove/{id}",method = RequestMethod.DELETE)
	public void deletePerson(@PathVariable("id") String id){
		employeeService.delete(id);
	}

}
