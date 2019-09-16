package com.cognizant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.models.ParentTasks;


public interface ParentTasksRepo extends JpaRepository<ParentTasks, Integer> {
	
	ParentTasks findByParentId(int parentId);
	
}
