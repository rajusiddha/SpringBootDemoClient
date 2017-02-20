package com.nisum.batch;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nisum.services.EmployeeService;

@Component
public class SpringBatch {
	private static final Logger log = LoggerFactory.getLogger(SpringBatch.class);
	
	@Autowired
	EmployeeService employeeService;
	Map<String,Object> paramMap;
	
	@Scheduled(cron ="0 0 1 * * *")
	public void batchProcessReport(){
		
		paramMap = new HashMap<String, Object>();
		
		
	}
}
