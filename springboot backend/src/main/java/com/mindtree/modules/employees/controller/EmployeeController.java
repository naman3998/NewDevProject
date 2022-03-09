package com.mindtree.modules.employees.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.modules.employees.entity.Employee;
import com.mindtree.modules.employees.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
@RestController
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {

		return employeeService.getAllEmployees();

	}
	
	/*
	 * @GetMapping("/employees") public List<Employee> getAll() { return
	 * employeeService.getAllEmployee(); }
	 */
	
	
	// create employee rest api
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
			return new ResponseEntity<Employee>(employeeService.createEmployee(employee), HttpStatus.CREATED);
		}
	
		/*
		 * @PostMapping("/employees") public void create_employee(@RequestBody Employee
		 * e) { System.out.println(e); employeeService.setEmployee(e); }
		 */
	
	
	
	// get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {

		/* Employee employee = employeeRepository.findById(id) */

		Employee employee = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}

	
	/*
	 * @GetMapping("/employees/{id}") public Optional<Employee>
	 * getById(@PathVariable Long id) { return employeeService.searchById(id); }
	 */
	
	// update employee rest api
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {

		Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
		return ResponseEntity.ok(updatedEmployee);

	}
	
	/*
	 * @PutMapping("/employees/{id}") public void update_employee(@PathVariable long
	 * id, @RequestBody Employee e) { employeeService.updateEmployee(id, e);
	 * 
	 * }
	 */
	
	
	// delete employee rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {

		employeeService.deleteEmployee(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}


/*
 * @DeleteMapping("/employees/{id}") public void delete_employee(@PathVariable
 * Long id) { employeeService.deleteEmployee(id); }
 * 
 * }
 */