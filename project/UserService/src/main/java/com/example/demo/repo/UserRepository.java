package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
	 List<User> findByRole(String role);
	 boolean existsByEmail(String email);
	 List<User> findByIsActiveTrue();
	 

}
