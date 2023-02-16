package com.hrsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrsystem.dto.EmployeeDTO;

@Service
public interface EmployeeService {

	EmployeeDTO createEmployee(EmployeeDTO employee) throws Exception;

	List<EmployeeDTO> getAllEmployees();

	EmployeeDTO updateEmployee(EmployeeDTO employee);

	void deleteEmployee(Long id);
	

}
