package com.cognizant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.models.ParentTasks;
import com.cognizant.models.Projects;
import com.cognizant.models.Tasks;
import com.cognizant.models.Users;
import com.cognizant.repositories.ParentTasksRepo;
import com.cognizant.repositories.ProjectsRepo;
import com.cognizant.repositories.TasksRepo;
import com.cognizant.repositories.UsersRepo;

@RestController
@RequestMapping("/api")
public class HomeController {

	@Autowired
	private UsersRepo usersRepo;

	@Autowired
	private ProjectsRepo projectsRepo;

	@Autowired
	private ParentTasksRepo parentTasksRepo;

	@Autowired
	private TasksRepo tasksRepo;

	@GetMapping("/users")
	public List<Users> getUsers() {
		return usersRepo.findAll();
	}

	@GetMapping("/projects")
	public List<Projects> getProjects() {
		return projectsRepo.findAll();
	}

	@GetMapping("/tasks")
	public List<Tasks> getTasks() {
		return tasksRepo.findAll();
	}

	@GetMapping("/parenttasks")
	public List<ParentTasks> getParentTasks() {
		return parentTasksRepo.findAll();
	}

}
