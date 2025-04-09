package com.example.demo.service;


import com.example.demo.model.User; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Lead;
import com.example.demo.model.SalesRecord;
import com.example.demo.repo.SalesRepository;

import java.util.List;

@Service
public class SalesService {
    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private RestTemplate restTemplate;

    public SalesRecord save(SalesRecord record) {
        return salesRepository.save(record);
    }

    public List<SalesRecord> getAllSales() {
        List<SalesRecord> records = salesRepository.findAll();
        records.forEach(this::setLeadAndUserInfo);
        return records;
    }

    public List<SalesRecord> getSalesByUser(Long userId) {
        List<SalesRecord> records = salesRepository.findByUserId(userId);
        records.forEach(this::setLeadAndUserInfo);
        return records;
    }

    public List<SalesRecord> getSalesByLead(Long leadId) {
        List<SalesRecord> records = salesRepository.findByLeadId(leadId);
        records.forEach(this::setLeadAndUserInfo);
        return records;
    }

    public void setLeadAndUserInfo(SalesRecord record) {
        Lead lead = restTemplate.getForObject("http://localhost:8082/api/leads/" + record.getLeadId(), Lead.class);
        User user = restTemplate.getForObject("http://localhost:8080/api/users/" + record.getUserId(), User.class);
        record.setLead(lead);
        record.setUser(user);
    }
}
