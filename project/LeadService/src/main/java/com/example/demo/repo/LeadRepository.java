package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Lead;
@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    List<Lead> findByUid(Long uid);
}