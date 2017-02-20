package com.nisum.services;

import java.util.List;

import com.nisum.domain.Employee;

public interface EmployeeService {

	List<Employee> getAll();

	void save(Employee employee);

	void delete(String id);

	void updatePerson(String id,Employee employee);

	Employee loadUserByUsername(String username);

}
