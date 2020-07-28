package com.projectcodeforce.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectcodeforce.entity.User;
import com.projectcodeforce.service.UserService;
import com.projectcodeforce.rest.UserValidator;

@RestController
@RequestMapping("/")
public class UserRestController {
	

	@Autowired
	private UserService userService;

	@Autowired
	public UserValidator userValidator;
	
	@Autowired
	public UserRestController(UserService theuserService) {
		userService=theuserService;
	}

	@ResponseBody
	@GetMapping("/login")
	public String loginpage() {
		return "login";
	}
//    public Model login(Model model, String error, String logout) {
//        if (error != null)
//        	
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
//        
//
//        return model ; // http status code
//    }
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestParam("Username") String emailId, @RequestParam("password") String password) {
		User u= UserService.findById(emailId);
		if(u==null) {
			// exception handling
          return new ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
		}
		if(emailId.equals(u.getEmailId() ) && password.equals(u.getPassword())) {
			return new ResponseEntity<>(HttpStatus.ACCEPTED); //json response 
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}
	
	@RequestMapping(path = "/registration", method = RequestMethod.GET)
	public Model registration(Model model) {
   model.addAttribute("userForm", new User());

    return model;
	}

    @RequestMapping(path = "/registration", method = RequestMethod.POST)
	public ResponseEntity<Object> registration(@ModelAttribute("userForm") User userForm, 
     BindingResult bindingResult, Model model) {
   userValidator.validate(userForm, bindingResult);

	    if (bindingResult.hasErrors()) {
	        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE); //json respnose 
	    }

    userService.save(userForm);


    return new ResponseEntity<>(userForm,HttpStatus.OK); //json
	}
	
    
	@GetMapping("/userlist")
	//List<User>
	public String userlist() {
		//model.addAllAttributes(userService.findAll());
		System.out.println("inside userlist mapping");
		
//		return userService.findAll();
		return "test";
		
	}



}
