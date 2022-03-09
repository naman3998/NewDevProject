package com.mindtree;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.modules.employees.entity.Employee;
import com.mindtree.modules.employees.repository.EmployeeRepository;
import com.mindtree.modules.employees.service.EmployeeService;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeTest {
	
	@Autowired
	 private EmployeeService service;
	
	@MockBean
	private EmployeeRepository repository;

	@Test
	void getAllEmployeesTest() {
		
		//when
		when(repository.findAll()).thenReturn(Stream.of(new Employee("Karan","Singh", "karansingh@email.com", "Angular"),new Employee("Nakul","Sharma","nakulsharma@email.com","React"),new Employee("Sundar","Verma","sundarverma@email.com", "Analytics")).collect(Collectors.toList()));
		
		// then-asserts
		assertEquals(3,service.getAllEmployees().size());
	}
	
	@Test
	void createEmployeeTest() {
		Employee employee=new Employee("Karan","Singh", "karansingh@email.com", "Angular");
		when(repository.save(employee)).thenReturn(employee);
		assertEquals(employee,service.createEmployee(employee));
	}
	
//	@Test
//	void getEmployeeById() {
//		Optional<Employee> employee = Optional.of(new Employee("Karan","Singh", "karansingh@email.com", "Angular"));
//		long id = 1;
//		when(repository.findById(id)).thenReturn(employee);
//		assertEquals(employee,service.getEmployeeById(id));
//	}
		
	}
	
