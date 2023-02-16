package com.hrsystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hrsystem.model.Task;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrsystem.dto.EmployeeDTO;
import com.hrsystem.model.Employee;
import com.hrsystem.repository.EmployeeRepository;
import com.hrsystem.repository.TaskRepository;

@Component
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	// CREATE
	
	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO)  throws Exception{
		Employee e1 = new Employee();
		
		e1.setFirstName(employeeDTO.getFirstName());
		e1.setLastName(employeeDTO.getLastName());
		e1.setEmail(employeeDTO.getEmail());


		if (!employeeRepository.existsByEmail(e1.getEmail())) {
			employeeRepository.save(e1);

			employeeDTO.setEmployeeId(e1.getId()); // save before set id to make sure the emp is saved.


		} else {
			//throw new Exception();
			return  null;
		}
		return employeeDTO;
	}
	
	
	// READ
	
	public List<EmployeeDTO> getAllEmployees() {
		
		List <Employee> employees = employeeRepository.findAll();
		
		return employees.stream()
						.map(employee -> modelMapper
						.map(employee, EmployeeDTO.class))
						.collect(Collectors.toList());
		
	}
	
	
	
	// UPDATE

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDto) {
		
		
		Optional<Employee> optionalEmp = employeeRepository.findById(employeeDto.getEmployeeId());
		
		/*
		 * TODO : refactor using lambda expressions
		 * 
		 * */

		if (optionalEmp.isPresent()) {
			
			Employee employee = optionalEmp.get();
			
			employee.setEmail(employeeDto.getEmail());
			employee.setFirstName(employeeDto.getFirstName());
			employee.setLastName(employeeDto.getLastName());
			
			employeeRepository.save(employee);
			
			
			EmployeeDTO updatedEmp = modelMapper.map(employee, EmployeeDTO.class);
			
			return updatedEmp;
		} else {
			return null;
			
		}		
				
	}

	
	
	// DELETE

	@Override
	public void deleteEmployee(Long id) {
		// find employees tasks
		

		List<Task> tasks = taskRepository.findAllByEmployeeId(id);
		taskRepository.deleteAll(tasks);
		
		// in one shot without querying the db
		//taskRepository.deleteAllByEmployeeId(id);
		
		employeeRepository.deleteById(id);
		
	}
	
	
	
	
	

	
	/*
	@Override
	public List<EmployeeDTO> getAllEmployeesNaive() {
		
		List<Employee> myEmployeesDAO = employeeRepository.findAll();
		List<EmployeeDTO> myEmployeesDTO = new ArrayList<EmployeeDTO>();
		
		for (int i=0;i<myEmployeesDAO.size();i++) {
			
			EmployeeDTO e = new EmployeeDTO();
			
			e.setEmail(myEmployeesDAO.get(i).getEmail());
			e.setFirstName(myEmployeesDAO.get(i).getFirstName());
			e.setLastName(myEmployeesDAO.get(i).getLastName());
			
			myEmployeesDTO.add(e);		
		}
		
		return myEmployeesDTO;
		
	}
	*/
	
	
	
	
	
	
	

	


}
