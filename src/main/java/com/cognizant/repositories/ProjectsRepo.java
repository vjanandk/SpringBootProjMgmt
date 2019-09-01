package com.cognizant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.models.Projects;

public interface ProjectsRepo extends JpaRepository<Projects, Integer> {

}
