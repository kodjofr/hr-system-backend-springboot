package com.hrsystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.hrsystem.dto.TaskDTO;
import com.hrsystem.model.Employee;
import com.hrsystem.model.Task;
import com.hrsystem.repository.EmployeeRepository;
import com.hrsystem.repository.TaskRepository;
import org.springframework.stereotype.Component;


@Component
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	
	// CREATE
	
	@Override
	public TaskDTO createTask(TaskDTO taskDto) {
		
		
		/* BUSINESS LOGIC OF CREATING A TASK
		 * 1. check if emp exists by their email
		 * 2. if not : task cannot be created
		 * 3. if found : create a Task object and 
		 * 4. set with taskDto attributes
		 * 5. save task
		 * 6. task -> taskDto or set taskId for less boilerplate code
		 */
		
		// 1
		Optional<Employee> optionalEmp = employeeRepository.findByEmail(taskDto.getEmailEmployee());
		if (optionalEmp.isPresent()) {
			Employee employee = optionalEmp.get();
			
			//3
			Task task = new Task();
			
			//4
			task.setTaskName(taskDto.getTaskName());
			task.setTaskDescription(taskDto.getTaskDescription());
			task.setEmployee(employee);
			
			//5
			task = taskRepository.save(task); // task = to retrieve a task 
			
			//6
			taskDto.setTaskId(task.getTaskId()); // save before set id to make sure the task is saved.
			
			
		} else {
			// 2 
			return null;
		}
		return taskDto;
	}

	
	// READ

	@Override
	public List<TaskDTO> getAllTasks() {
		List<Task> tasks = taskRepository.findAll();
		
		return tasks.stream()
				.map(task -> modelMapper.map(task, TaskDTO.class)).
				collect(Collectors.toList());
	}


	
	// READ DETAILS 
	@Override
	public TaskDTO getTaskDetails(Long id) {
		
		Optional<Task>optionalTask = taskRepository.findById(id);
		
		if(optionalTask.isPresent()) {
			Task myTask = optionalTask.get();
			return modelMapper.map(myTask, TaskDTO.class);
		} else  {
			return null; // resource not found exception
			
		}
	}
	
	
	
	
	

	// UPDATE
	
	
	@Override
	public TaskDTO updateTask(TaskDTO taskDto) {
		Optional<Task> optionalTask = taskRepository.findById(taskDto.getTaskId());
		
		if(optionalTask.isPresent()) {
			Task task = optionalTask.get();
			
			task.setTaskDescription(taskDto.getTaskDescription());
			task.setTaskName(taskDto.getTaskName());
			
			Optional<Employee> optionalEmp = employeeRepository.findByEmail(taskDto.getEmailEmployee());
			Employee emp = optionalEmp.get();
			task.setEmployee(emp);
			
			Task updatedTask = taskRepository.save(task);
			
			return modelMapper.map(updatedTask, TaskDTO.class);
			
			
			
			
		} else {
			return null; // RESOURCE NOT FOUND ERROR
		}
	}

	
	
	// DELETE
	
	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
	
	
	
	

}
