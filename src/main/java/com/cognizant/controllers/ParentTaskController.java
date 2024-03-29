package com.cognizant.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.models.ParentTasks;
import com.cognizant.repositories.ParentTasksRepo;

@RestController
@RequestMapping("/api")
public class ParentTaskController {

	@Autowired
	private ParentTasksRepo parentTasksRepo;

	@GetMapping("/parenttasks")
	public List<ParentTasks> getParentTasks() {
		System.out.println("GET - Inside /parenttasks");
		return parentTasksRepo.findAll();
	}
	
	@GetMapping("/parenttasks/{parentId}")
	public ParentTasks getParentTasks(@PathVariable Integer parentId) {
		System.out.println("GET - Inside /parenttasks/{parentId} : "+ parentId);
		return parentTasksRepo.findByParentId(parentId);
	}

	
	@PostMapping("/parenttasks")
	public String addparenttask(@RequestBody ParentTasks parenttasks) {
		System.out.println("POST - Inside /parenttasks :" + parenttasks);
		parentTasksRepo.save(parenttasks);
		return "Requested parent task has been added into the system." + parenttasks;
	}

	
}
