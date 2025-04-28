package com.example.demo.sevices;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.DTOclasses.LeadDTO;
import com.example.demo.DTOclasses.SalesRecordDTO;
import com.example.demo.DTOclasses.UserDTO;
import com.example.demo.model.SalesRecord;
import com.example.demo.repo.SalesRepository;

@Service
public class SalesService {

    @Autowired
    private SalesRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    public List<SalesRecordDTO> getAllSales() {
        List<SalesRecord> records = repo.findAll();
        return records.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<SalesRecordDTO> getSalesByUser(Long userId) {
        List<SalesRecord> records = repo.findByUserId(userId);
        return records.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private SalesRecordDTO convertToDTO(SalesRecord record) {
        SalesRecordDTO dto = new SalesRecordDTO();
        BeanUtils.copyProperties(record, dto);

        LeadDTO lead = restTemplate.getForObject("http://localhost:8082/api/leads/" + record.getLeadId(), LeadDTO.class);
        UserDTO user = restTemplate.getForObject("http://localhost:8080/api/users/id/" + record.getUserId(), UserDTO.class);

        dto.setLead(lead);
        dto.setUser(user);
        return dto;
    }

    public SalesRecord save(SalesRecord record) {
        return repo.save(record);
    }
}
