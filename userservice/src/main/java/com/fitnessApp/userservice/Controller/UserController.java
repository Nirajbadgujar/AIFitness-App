package com.fitnessApp.userservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitnessApp.userservice.dto.RegisterRequest;
import com.fitnessApp.userservice.dto.UserResponse;
import com.fitnessApp.userservice.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request) {
		return ResponseEntity.ok(userService.register(request));
	}

	@GetMapping("/findbyid/{id}")
	public ResponseEntity<UserResponse> findById(@PathVariable String id) {
		return ResponseEntity.ok(userService.findUser(id));
	}
}
