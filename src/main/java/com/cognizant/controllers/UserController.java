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

import com.cognizant.models.Users;
import com.cognizant.repositories.UsersRepo;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UsersRepo usersRepo;
	
	
	@GetMapping("/users")
	public List<Users> getUsers() {
		System.out.println("GET - Inside /users");
		return usersRepo.findAll();
	}
	
	@GetMapping("/users/{empId}")
	public Users getuser(@PathVariable("empId") int empId) {
		System.out.println("GET - Inside /users/{empId} :" + empId);
		return usersRepo.findByEmpId(empId);
	}
	
	@PostMapping("/users")
	public String adduser(@RequestBody Users users) {
		System.out.println("POST - Inside /users :" + users);
		usersRepo.save(users);
		return "Requested user has been added into the system." + users;
	}

	@PutMapping("/users")
	public String updateuser(@RequestBody Users users) {
		System.out.println("PUT - Inside /users :" + users);
		usersRepo.save(users);
		return "Requested user has been updated into the system." + users;
	}

}
