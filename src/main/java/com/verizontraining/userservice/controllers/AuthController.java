package com.verizontraining.userservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.verizontraining.userservice.clientrequests.NotificationServiceProxy;
import com.verizontraining.userservice.request.RegistrationRequest;
import com.verizontraining.userservice.services.UserService;

@RestController
public class AuthController {
  
	@Autowired
	private UserService userService;
	
	@Autowired
	private NotificationServiceProxy proxy;
	
	@PostMapping("/registration")
	public void registerUser(@RequestBody RegistrationRequest registerRequest) throws Exception {
		//check user with provided email exists or not
		
		
         if(!userService.checkUserExists(registerRequest.getEmail())){
        	 throw new Exception("User Exists");
         }
         
         userService.save(registerRequest);
         
         proxy.SendRegistrationEmail(registerRequest.getEmail());
         
		
	   
	}
}
