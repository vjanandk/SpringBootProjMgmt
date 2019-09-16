package com.cognizant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.models.Tasks;
import com.cognizant.models.Users;
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
	
	@GetMapping("/tasks/{taskName}")
	public Tasks updateusertask(@PathVariable String taskName) {
		System.out.println("/tasks/{taskName}" + taskName);
		Tasks task = new Tasks();
		try {
			task = tasksRepo.findByTaskName(taskName);
		} catch (Exception e) {
			System.out.println("Task Name Found");
		}
		
		return task;
	}
	
	@GetMapping("/tasks/{projId}/{taskId}")
	public List<Tasks> gettaskid(@PathVariable Integer projId) {
		System.out.println("/tasks/{projId}/{taskId}" + projId);
		List<Tasks> task = null;
		try {
			task = tasksRepo.findByProjId(projId);
		} catch (Exception e) {
			System.out.println("Project ID Not Found");
		}
		
		return task;
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
