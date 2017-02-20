package com.nisum.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nisum.domain.Employee;

@Repository
public interface UserRoleRepository extends MongoRepository<Employee, String>{

	Employee findByUserName(String userName);
	
	Employee findByUserNameAndPassword(String userName, String password);
}
