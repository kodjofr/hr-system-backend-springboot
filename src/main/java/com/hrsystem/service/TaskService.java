package com.hrsystem.service;

import java.util.List;

import com.hrsystem.dto.TaskDTO;

public interface TaskService {

	TaskDTO createTask(TaskDTO taskDto);

	List<TaskDTO> getAllTasks();

	TaskDTO getTaskDetails(Long id);

	TaskDTO updateTask(TaskDTO taskDto);

	void deleteTask(Long id);

}
