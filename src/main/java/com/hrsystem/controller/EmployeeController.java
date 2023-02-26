package com.hrsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hrsystem.dto.EmployeeDTO;
import com.hrsystem.service.EmployeeService;



@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDto) throws Exception{
		return employeeService.createEmployee(employeeDto);
	}
	
	@GetMapping("/all")
	public List<EmployeeDTO> getAllEmployees() {
		return employeeService.getAllEmployees();	
	}

	@GetMapping("{id}")
	public EmployeeDTO getEmployeeInfos(@PathVariable("id") Long id) {
		return employeeService.getEmployeeInfos(id);
	}
	
	
	@PutMapping("/update")
	public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDto) {
		return employeeService.updateEmployee(employeeDto);
	}
	
	
	@DeleteMapping("{id}")
	public void deleteEmployee(@PathVariable("id")Long id) {
		employeeService.deleteEmployee(id);	
	}
	
	

}
