package com.cognizant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		System.out.println("Inside /users");
		return usersRepo.findAll();
	}

	@GetMapping("/projects")
	public List<Projects> getProjects() {
		System.out.println("Inside /projects");
		return projectsRepo.findAll();
	}

	@GetMapping("/tasks")
	public List<Tasks> getTasks() {
		System.out.println("Inside /tasks");
		return tasksRepo.findAll();
	}

	@GetMapping("/parenttasks")
	public List<ParentTasks> getParentTasks() {
		System.out.println("Inside /parenttasks");
		return parentTasksRepo.findAll();
	}

	@GetMapping("/users/{empId}")
	public Users getuser(@PathVariable("empId") int empId) {
		System.out.println("Inside /users/{empId} :" + empId);
		return usersRepo.findByEmpId(empId);
	}

	@GetMapping("/projects/{projName}")
	public List<Projects> getproject(@PathVariable("projName") String projName) {
		System.out.println("Inside /projects/{projName} :" + projName);
		List<Projects> projects = projectsRepo.findByProjName(projName);
		return projects;
	}
}
