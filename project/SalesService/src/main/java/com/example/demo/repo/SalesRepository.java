package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SalesRecord;

public interface SalesRepository extends JpaRepository<SalesRecord, Long> {
    List<SalesRecord> findByUserId(Long userId);
    List<SalesRecord> findByLeadId(Long leadId);
    List<SalesRecord> findByStatus(String status);
}
