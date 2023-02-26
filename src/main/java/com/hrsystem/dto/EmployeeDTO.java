package com.hrsystem.dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class EmployeeDTO {
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String departmentName;
	private String email;

	

}
