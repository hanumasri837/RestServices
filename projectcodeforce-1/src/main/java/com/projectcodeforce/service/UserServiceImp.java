package com.projectcodeforce.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectcodeforce.dao.UserRepository;
import com.projectcodeforce.entity.User;
import java.util.*;

@Service
public class UserServiceImp implements UserService {

	private UserRepository userrepo;
	
	@Autowired
	public UserServiceImp(UserRepository theuserRepository) {
		userrepo = theuserRepository;
	}
		
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userrepo.findAllByOrderByLastNameAsc();
	}

	public User findById(String emailId) {
		// TODO Auto-generated method stub
		User u = null;
		Optional<User> ou = Optional.ofNullable(userrepo.findById(emailId));
		if(ou.isPresent()) {
			u = ou.get();
		}
			
	return u;
	}

	@Override
	public void save(User theUser) {
		// TODO Auto-generated method stub
		userrepo.save(theUser);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		userrepo.deleteById(theId);
	}

}
