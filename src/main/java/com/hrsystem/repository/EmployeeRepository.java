package com.hrsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrsystem.model.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	boolean existsByEmail(String email);

	Optional<Employee> findByEmail(String emailEmployee);

	
	

}
