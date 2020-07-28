package com.projectcodeforce.service;

import java.util.List;

import com.projectcodeforce.entity.User;



public interface UserService {


	public List<User> findAll();
	
	public static User findById(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void save(User theUser);
	
	public void deleteById(int theId);




}
