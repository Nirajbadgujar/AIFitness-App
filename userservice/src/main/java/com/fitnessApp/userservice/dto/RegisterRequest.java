package com.fitnessApp.userservice.dto;

import lombok.Data;

@Data
public class RegisterRequest {
	
	private String email;
	private String firstName;
	private String lastname;
	private String password;
	
}
