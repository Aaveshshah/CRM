package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Contact;
import com.example.demo.model.Lead;
import com.example.demo.repo.LeadRepository;

import java.util.List;

@Service
public class LeadService {
    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private RestTemplate restTemplate;  // For calling User & Contact Service

    public List<Lead> getAllLeads() {
        List<Lead> leads = leadRepository.findAll();

        leads.forEach(lead -> {
            List<Contact> contacts = restTemplate.getForObject("http://localhost:8082/api/contacts/lead/" + lead.getId(), List.class);
            lead.setContact(contacts); // Set the contacts inside the lead object
        });

        return leads;
    }
    public Lead saveLead(Lead lead) {
        return leadRepository.save(lead);
    }

    public Lead assignLeadToUser(Long leadId, Long userId) {
        Lead lead = leadRepository.findById(leadId)
                .orElseThrow(() -> new RuntimeException("Lead not found"));

        // Check if user exists in User Service
        String userServiceUrl = "http://localhost:8080/api/users/" + userId;
        Boolean userExists = restTemplate.getForObject(userServiceUrl, Boolean.class);

        if (Boolean.TRUE.equals(userExists)) {
        	
            lead.setUid(userId);
            
            return leadRepository.save(lead);
        } else {
            throw new RuntimeException("User not found in User Service");
        }
    }

    public List<Lead> getLeadsByUserId(Long userId) {
        return leadRepository.findByUid(userId);
    }

    public Lead getLeadById(Long id) {
        Lead lead = leadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lead not found"));

        // Fetch contacts for this lead
        List<Contact> contacts = restTemplate.getForObject("http://localhost:8082/api/contacts/lead/" + lead.getId(), List.class);
        lead.setContact(contacts);

        return lead;
    }
}