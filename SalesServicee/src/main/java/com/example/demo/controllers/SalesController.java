package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOclasses.SalesRecordDTO;
import com.example.demo.model.SalesRecord;
import com.example.demo.sevices.SalesService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping("/all")
    public ResponseEntity<List<SalesRecordDTO>> getAll() {
        return ResponseEntity.ok(salesService.getAllSales());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<SalesRecordDTO>> getByUser(@PathVariable Long id) {
        return ResponseEntity.ok(salesService.getSalesByUser(id));
    }

    @PostMapping
    public ResponseEntity<SalesRecord> create(@RequestBody SalesRecord record) {
        return ResponseEntity.status(HttpStatus.CREATED).body(salesService.save(record));
    }
}
