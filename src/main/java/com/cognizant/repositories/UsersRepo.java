package com.cognizant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.models.Users;

public interface UsersRepo extends JpaRepository<Users, Integer> {

	Users findByEmpId(int empId);

}
