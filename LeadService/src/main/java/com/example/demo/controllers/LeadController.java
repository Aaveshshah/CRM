package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LeadService;
import com.example.demo.model.Lead;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/leads")
public class LeadController {
    @Autowired
    private LeadService leadService;

    @GetMapping("/all")
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }

    @PostMapping("/save")
    public ResponseEntity<Lead> createLead(@RequestBody Lead lead) {
        return ResponseEntity.ok(leadService.saveLead(lead));
    }

    @PutMapping("/{leadId}/assign/{userId}")
    public ResponseEntity<Lead> assignLeadToUser(@PathVariable Long leadId, @PathVariable Long userId) {
    	
        return ResponseEntity.ok(leadService.assignLeadToUser(leadId, userId));
    }

    @GetMapping("/userid/{userId}")
    public List<Lead> getLeadsByUserId(@PathVariable Long userId) {
    	
        return leadService.getLeadsByUserId(userId);
        
    }
    @GetMapping("/{id}")
    public ResponseEntity<Lead> getLeadById(@PathVariable Long id) {
        return ResponseEntity.ok(leadService.getLeadById(id));
    }
}