package com.nisum.repository;

import org.springframework.data.repository.CrudRepository;

import com.nisum.domain.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, String>{

}
