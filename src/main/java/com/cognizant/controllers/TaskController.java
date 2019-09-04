package com.cognizant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.models.Tasks;
import com.cognizant.repositories.TasksRepo;

@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private TasksRepo tasksRepo;
	
	@GetMapping("/tasks")
	public List<Tasks> getTasks() {
		System.out.println("GET - Inside /tasks");
		return tasksRepo.findAll();
	}
	
	@PostMapping("/tasks")
	public String addtask(@RequestBody Tasks tasks) {
		System.out.println("POST - Inside /tasks :" + tasks);
		tasksRepo.save(tasks);
		return "Requested task has been added into the system." + tasks;
	}

	@PutMapping("/tasks")
	public String updatetask(@RequestBody Tasks tasks) {
		System.out.println("PUT - Inside /tasks :" + tasks);
		tasksRepo.save(tasks);
		return "Requested task has been updated into the system." + tasks;
	}

}
