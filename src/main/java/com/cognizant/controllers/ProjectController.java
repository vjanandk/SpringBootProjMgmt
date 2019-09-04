package com.cognizant.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.models.Projects;
import com.cognizant.repositories.ProjectsRepo;

@RestController
@RequestMapping("/api")
public class ProjectController {

	@Autowired
	private ProjectsRepo projectsRepo;

	@GetMapping("/projects")
	public List<Projects> getProjects() {
		System.out.println("GET - Inside /projects");
		return projectsRepo.findAll();
	}

	@PostMapping("/projects")
	public String addproject(@RequestBody Projects projects) {
		System.out.println("POST - Inside /projects :" + projects);
		projectsRepo.save(projects);
		return "Requested project has been added into the system." + projects;
	}
	
	
	
//	@GetMapping("/projects/{projName}")
//	public List<Projects> getproject(@PathVariable("projName") String projName) {
//		System.out.println("GET - Inside /projects/{projName} :" + projName);
//		List<Projects> projects = projectsRepo.findByProjName(projName);
//		return projects;
//	}


}
