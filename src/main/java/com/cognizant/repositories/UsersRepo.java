package com.cognizant.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.models.Users;

public interface UsersRepo extends JpaRepository<Users, Integer> {

	Users findByEmpId(int empId);

	Users findByUserId(int userId);
	
	@Transactional
	@Modifying
	@Query("delete from Users where empId = :empId")
	void deleteByEmpId(int empId);
	
	@Query("from Users where projId = :projId and taskId = 0")
	Users findByProjId(int projId);
}
