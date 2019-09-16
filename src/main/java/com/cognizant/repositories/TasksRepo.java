package com.cognizant.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.models.Tasks;

public interface TasksRepo extends JpaRepository<Tasks, Integer>{

	Tasks findByTaskName(String taskName);
	List<Tasks> findByProjId(int projId);
}
