package com.cognizant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	@GetMapping("/users/{userId}")
	public Users updateuserproj(@PathVariable Integer userId) {
		System.out.println("/users/{userId}" + userId);
		Users user = new Users();
		try {
			user = usersRepo.findByUserId(userId);
		} catch (Exception e) {
			System.out.println("User Id Not Found");
		}

		return user;
	}

	
	@GetMapping("/users/{projId}/{taskId}")
	public Users getManager(@PathVariable Integer projId, @PathVariable Integer taskId) {
		System.out.println("/users/{projId}/{taskId}" + projId + "," + taskId);
		Users user = new Users();
		try {
			user = usersRepo.findByProjId(projId);
		} catch (Exception e) {
			System.out.println("User Id Not Found For Given Proj Id ");
		}

		return user;
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

	@DeleteMapping("/users/{empId}")
	public String deleteuser(@PathVariable Integer empId) {
		System.out.println("Delete - I/users/{empId} : " + empId);
		usersRepo.deleteByEmpId(empId);
		return "Requested information has been deleted - empId : " + empId;
	}

//	@PutMapping("/users/updproj/{userId}/{projId}")
//	public String updateuserproj(@PathVariable Integer userId, @PathVariable Integer projId) {
//		System.out.println("/users/updproj/" + userId + "/" + projId);
//		
//		try {
//			Users user = usersRepo.findByUserId(userId);
//			user.setProjId(projId);
//			usersRepo.save(user);	
//		} catch (Exception e) {
//			System.out.println("User Id Not Found");
//		}
//		
//		return "Request Success - /users/updproj/" + userId + "/" + projId;
//	}
//	
//	
//	@PutMapping("/users/updtask/{userId}/{taskId}")
//	public String updateusertask(@PathVariable Integer userId, Integer taskId) {
//		System.out.println("/users/updtask/" + userId + "/" + taskId);
//		
//		try {
//			Users user = usersRepo.getOne(userId);
//			user.setTaskId(taskId);
//			usersRepo.save(user);	
//		} catch (Exception e) {
//			System.out.println("User Id Not Found");
//		}
//		
//		return "Request Success - /users/updtask/" + userId + "/" + taskId;
//	}

//	@GetMapping("/users/{empId}")
//	public Users getuser(@PathVariable("empId") int empId) {
//		System.out.println("GET - Inside /users/{empId} :" + empId);
//		return usersRepo.findByEmpId(empId);
//	}

}
