package com.hrsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.dto.TaskDTO;
import com.hrsystem.service.TaskService;



@RestController
@RequestMapping("api/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	
	
	@PostMapping
	public TaskDTO createTask(@RequestBody TaskDTO taskDto) {
		return taskService.createTask(taskDto);
	}
	
	
	@GetMapping
	public List<TaskDTO> getAllTask() {
		return taskService.getAllTasks();
	}
	
	@GetMapping("{id}")
	public TaskDTO getTaskDetails(@PathVariable("id") Long id) {
		return taskService.getTaskDetails(id);
	}
	
	
	@PutMapping
	public TaskDTO updateTask(@RequestBody TaskDTO taskDto) {
		return taskService.updateTask(taskDto);
	}
	
	
	@DeleteMapping("{id}")
	public void deleteTask(@PathVariable("id") Long id) {
		taskService.deleteTask(id);
	}
	

}
