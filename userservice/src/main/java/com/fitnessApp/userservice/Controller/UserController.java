package com.fitnessApp.userservice.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitnessApp.userservice.dto.RegisterRequest;
import com.fitnessApp.userservice.dto.UserResponse;
import com.fitnessApp.userservice.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request){
		return ResponseEntity.ok(userService.register(request));
	}
}
