package com.fitnessApp.userservice.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnessApp.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Boolean getByEmail(String email);

}
