package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByLeadId(Long leadId);
}
