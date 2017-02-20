package com.nisum.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.nisum.domain.Employee;
import com.nisum.repository.EmployeeRepository;
import com.nisum.services.EmployeeService;

@Service
public class EmployeeServieImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository; 
	
	@Override
	public List<Employee> getAll() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	public void delete(String id) {
		employeeRepository.delete(id);
	}

	@Override
	public void updatePerson(String id,Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee loadUserByUsername(String username) {
		return employeeRepository.findOne(username);
	}

}
