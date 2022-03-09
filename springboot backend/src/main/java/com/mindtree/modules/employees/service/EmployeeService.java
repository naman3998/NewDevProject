package com.mindtree.modules.employees.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mindtree.modules.employees.entity.Employee;


@Service

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee createEmployee(Employee employee);
	public Employee  getEmployeeById(long id);
	public boolean deleteEmployee(long id);
	public Employee updateEmployee(long id, Employee employeeDetails);
	
}
//public interface EmployeeService {
//	public List<Employee> getAllEmployee();
//	public void setEmployee(Employee e);
//	public Optional<Employee> searchById(Long id);
//	public void updateEmployee(Long id,Employee e);
//	public void deleteEmployee(Long id);
//
//}
