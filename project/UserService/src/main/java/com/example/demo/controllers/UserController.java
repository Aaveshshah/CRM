package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	public UserService userService;

	// Get all users
	@GetMapping("/all")
	public List<User> getAllUsers() {

		List<User> l = userService.getAllUsers();
		return l;
	}

	// Register new user
	@PostMapping
	public ResponseEntity<User> createUser(@Validated @RequestBody User user) {
		return ResponseEntity.ok(userService.saveUser(user));
	}

	// Get user by username
	@GetMapping("/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	// Update user by ID
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
		User updatedUser = userService.updateUser(id, userDetails);
		return ResponseEntity.ok(updatedUser);
	}

	// Delete user by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/role/{role}")
	public List<User> getUsersByRole(@PathVariable String role) {
		return userService.getUsersByRole(role);
	}

	@DeleteMapping("/deactive/{id}")
	public ResponseEntity<Void> deactivateUser(@PathVariable Long id) {
		userService.deactivateUser(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/active")
	public List<User> getActiveUsers() {
		return userService.getActiveUsers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		return userService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	

}
