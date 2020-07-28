package com.projectcodeforce.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectcodeforce.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>  {

	
	public List<User> findAllByOrderByLastNameAsc();

	public User findById(String emailId);
	
	public void saveUser(User theUser);
	
}
