package com.nisum.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;

import com.nisum.domain.Employee;
import com.nisum.repository.EmployeeRepository;
import com.nisum.services.impl.EmployeeServieImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
	@Mock
	EmployeeRepository empRepository;

	@InjectMocks
	EmployeeServieImpl employeeServieImpl;
	ResultActions action;

	

	@Test
	public void getAllEmployeesTest() {
		List<Employee> emplist = new ArrayList<Employee>();
		Employee emp = new Employee();
		emp.setId("13224");
		emp.setUserName("xyz");
		emp.setEmail("xyz@gmail.com");
		emp.setRole("USER");
		emp.setPassword("abcd1234");
		emplist.add(emp);
		when(empRepository.findAll()).thenReturn(emplist);
		assertEquals("13224", employeeServieImpl.getAll().get(0).getId());
	}
	

}
