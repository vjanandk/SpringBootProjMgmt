package com.cognizant.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.models.Projects;

public interface ProjectsRepo extends JpaRepository<Projects, Integer> {

//	@Query("from Projects where lower(projName) like %:projName%")
//	List<Projects> findByProjName(String projName);

}
