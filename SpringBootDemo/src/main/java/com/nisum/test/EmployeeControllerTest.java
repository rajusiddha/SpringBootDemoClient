package com.nisum.test;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.google.gson.Gson;
import com.nisum.controllers.EmplyeeController;
import com.nisum.domain.Employee;
import com.nisum.services.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

	@Mock
	EmployeeService empService;

	@InjectMocks
	EmplyeeController emplyeeController;

	MockMvc mockMVC;

	ResultActions action;

	@Before
	public void setUp() {

		mockMVC = MockMvcBuilders.standaloneSetup(emplyeeController).build();
	}

	@Test
	public void getTest() throws Exception {
		List<Employee> emplist = new ArrayList<Employee>();
		Employee emp = new Employee();
		emp.setId("13224");
		emp.setUserName("xyz");
		emp.setEmail("xyz@gmail.com");
		emp.setRole("USER");
		emp.setPassword("abcd1234");
		emplist.add(emp);
		when(empService.getAll()).thenReturn(emplist);
		action = mockMVC.perform(get("/employee"));
		action.andExpect(status().isOk());
		action.andExpect(jsonPath("$[0].id", is("13224")));
	}

	@Test
	public void postTest() throws Exception {
		Employee emp = new Employee();
		emp.setId("13224");
		emp.setUserName("xyz");
		emp.setEmail("xyz@gmail.com");
		emp.setRole("USER");
		emp.setPassword("abcd1234");
		action = mockMVC.perform(
				post("/employee/save").content(new Gson().toJson(emp)).contentType(MediaType.APPLICATION_JSON));
		action.andExpect(status().isOk());
	}

	@Test
	public void deleteTest() throws Exception {
		Employee emp = new Employee();
		emp.setId("13224");
		emp.setUserName("xyz");
		emp.setEmail("xyz@gmail.com");
		emp.setRole("USER");
		emp.setPassword("abcd1234");
		action = mockMVC.perform(delete("/employee//remove/{id}", emp.getId()));
		action.andExpect(status().isOk());
	}

}
