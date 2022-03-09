package com.mindtree.modules.employees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.modules.employees.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	public List<Employee> findAll();

}

