package com.hrsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrsystem.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findAllByEmployeeId(Long id);

	void deleteAllByEmployeeId(Long id);

}
