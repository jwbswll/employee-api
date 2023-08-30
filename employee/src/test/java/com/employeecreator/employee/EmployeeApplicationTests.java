package com.employeecreator.employee;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeApplicationTests {

	@Autowired
	private EmployeeController controller;

	@Test
	void contextLoads() {
		assertNotNull(controller);
	}

}
