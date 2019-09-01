package com.cognizant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.models.Tasks;

public interface TasksRepo extends JpaRepository<Tasks, Integer>{

}
