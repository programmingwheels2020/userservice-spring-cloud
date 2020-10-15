package com.verizontraining.userservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizontraining.userservice.models.User;
import com.verizontraining.userservice.repository.UserRepository;
import com.verizontraining.userservice.request.RegistrationRequest;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public boolean checkUserExists(String email) {
		
		List<User> users = userRepository.findByEmail(email);
		return users.isEmpty();
	}

	public void save(RegistrationRequest registerRequest) {
		User user = new User();
		user.setEmail(registerRequest.getEmail());
		user.setName(registerRequest.getName());
		user.setPassword(registerRequest.getPassword());
		userRepository.save(user);
		
	}
}
