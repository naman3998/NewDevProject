package com.mindtree.modules.employees.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.modules.employees.entity.Employee;
import com.mindtree.modules.employees.repository.EmployeeRepository;
import com.mindtree.modules.exception.ResourceNotFoundException;



@Service
public class EmployeeServiceImple implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;


public EmployeeServiceImple(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee) {
	
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		//Optional<Employee> optional = employeeRepository.findById(id);
//		Employee employee = null;
//		if (optional.isPresent()) {
//			employee = optional.get();
//		} else {
//			throw new RuntimeException(" Employee not found for id :: " + id);
//		}
//		return employee;//


return employeeRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
	}


	@Override
	public Employee updateEmployee(long id, Employee employeeDetails) {
		
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setSkills(employeeDetails.getSkills());
		employeeRepository.save(employee);
		return employee ;
	}

	@Override
	public boolean deleteEmployee(long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new
				  ResourceNotFoundException("Employee not exist with id :" + id));
				  employeeRepository.delete(employee);
				  return true;
				  
			
	}

}


//public class EmployeeServiceImple implements EmployeeService {
//
//	@Autowired
//	public EmployeeRepository repo;
//
//	@Override
//	public List<Employee> getAllEmployee() {
//
//		return repo.findAll();
//
//	}
//
//	@Override
//	public void setEmployee(Employee employee) {
//		repo.save(employee);
//
//	}
//
//	@Override
//	public Optional<Employee> searchById(Long id) {
//		return repo.findById(id);
//	}
//
//	@Override
//	public void updateEmployee(Long id, Employee e) {
//		try {
//			Employee e1 = repo.findById(id).orElseThrow(() -> new Exception("no user found"));
//			e1.seteName(e.geteName());
//			e1.setEmail(e.getEmail());
//			e1.setPassword(e.getPassword());
//			e1.addSkills(e.getSkills());
//			repo.save(e1);
//		} catch (Exception e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//
//	}
//
//	@Override
//	public void deleteEmployee(Long id) {
//
//		repo.deleteById(id);
//
//	}
//
//}
