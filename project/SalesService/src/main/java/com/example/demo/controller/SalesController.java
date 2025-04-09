package com.example.demo.controller;


import com.example.demo.model.SalesRecord;
import com.example.demo.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @PostMapping
    public SalesRecord save(@RequestBody SalesRecord record) {
        return salesService.save(record);
    }

    @GetMapping
    public List<SalesRecord> getAll() {
        return salesService.getAllSales();
    }

    @GetMapping("/user/{userId}")
    public List<SalesRecord> getByUser(@PathVariable Long userId) {
        return salesService.getSalesByUser(userId);
    }

    @GetMapping("/lead/{leadId}")
    public List<SalesRecord> getByLead(@PathVariable Long leadId) {
        return salesService.getSalesByLead(leadId);
    }
}
