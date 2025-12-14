package com.fitnessApp.userservice.service;

import org.springframework.stereotype.Service;

import com.fitnessApp.userservice.UserRepository.UserRepository;
import com.fitnessApp.userservice.dto.RegisterRequest;
import com.fitnessApp.userservice.dto.UserResponse;
import com.fitnessApp.userservice.model.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private UserRepository repository;

	public UserResponse register(RegisterRequest request) {

		if (repository.existsByEmail(request.getEmail())) {
			throw new RuntimeException("User Already Exists");
		}

		User user = new User();
		user.setEmail(request.getEmail());
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setPassword(request.getPassword());

		User savedUser = repository.save(user);
		UserResponse userResponse = new UserResponse();
		userResponse.setId(savedUser.getId());
		userResponse.setPassword(savedUser.getPassword());
		userResponse.setEmail(savedUser.getEmail());
		userResponse.setFirstName(savedUser.getFirstName());
		userResponse.setLastName(savedUser.getLastName());
		userResponse.setCreatedAt(savedUser.getCreatedAt());
		userResponse.setUpdatedAt(savedUser.getUpdatedAt());

		return userResponse;
	}

	public UserResponse findUser(String id) {
		User user = repository.findById(id).orElseThrow(() -> new RuntimeException("User Not found"));
		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setPassword(user.getPassword());
		userResponse.setEmail(user.getEmail());
		userResponse.setFirstName(user.getFirstName());
		userResponse.setLastName(user.getLastName());
		userResponse.setCreatedAt(user.getCreatedAt());
		userResponse.setUpdatedAt(user.getUpdatedAt());

		return userResponse;
	}

}
