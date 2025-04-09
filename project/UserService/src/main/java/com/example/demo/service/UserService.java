package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Leads;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    RestTemplate rt;
 
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();

        for (User user : allUsers) {
            List<Leads> leads = rt.getForObject(
                "http://localhost:8082/api/leads/userid/" + user.getId(), ArrayList.class
            );
            user.setLeads(leads);
        }
        return allUsers;
    }


    public User saveUser(User user) {
    	 if (userRepository.existsByEmail(user.getEmail())) {
    	        throw new RuntimeException("Email already exists!");
    	    }
    	    return userRepository.save(user);
    }

    public Optional<User> getUserByUsername(String username) {
    	Optional<User> singleuser= userRepository.findByUsername(username);
        
       User lead = null ; 
            List<Leads> l = rt.getForObject("http://localhost:8082/api/leads/userid/"+lead.getId(), ArrayList.class);
            lead.setLeads(l);
        
        return singleuser;
    }
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        user.setRole(userDetails.getRole());

        return userRepository.save(user);

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public List<User> getUsersByRole(String role) {
        List<User> users = userRepository.findByRole(role);

        users.forEach(user -> {
            if (user.isActive()) {
                List<Leads> leads = rt.getForObject(
                    "http://localhost:8082/api/leads/userid/" + user.getId(), ArrayList.class
                );
                user.setLeads(leads);
            }
        });

        return users;
    }


    public void deactivateUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setActive(false);
        userRepository.save(user);
    }
    
    public List<User> getActiveUsers() {
        return userRepository.findByIsActiveTrue();
    }

    public Optional<User> getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (user.isActive()) {
                List<Leads> leads = rt.getForObject(
                    "http://localhost:8081/api/leads/userid/" + user.getId(), ArrayList.class
                );
                user.setLeads(leads);
            }
            return Optional.of(user);
        }
        return Optional.empty();
    }
}

