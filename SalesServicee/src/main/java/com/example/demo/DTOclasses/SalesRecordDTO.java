package com.example.demo.DTOclasses;

import java.time.LocalDateTime;

public class SalesRecordDTO {
    private Long id;
    private String dealName;
    private Double amount;
    private String status; // Open, In Progress, Won, Lost
    private Long leadId;
    private Long userId;
    private LocalDateTime createdAt;

    private LeadDTO lead;
    private UserDTO user;

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getLeadId() {
        return leadId;
    }

    public void setLeadId(Long leadId) {
        this.leadId = leadId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LeadDTO getLead() {
        return lead;
    }

    public void setLead(LeadDTO lead) {
        this.lead = lead;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

   

    public SalesRecordDTO() {}

    public SalesRecordDTO(Long id, String dealName, Double amount, String status,
                          Long leadId, Long userId, LocalDateTime createdAt,
                          LeadDTO lead, UserDTO user) {
        this.id = id;
        this.dealName = dealName;
        this.amount = amount;
        this.status = status;
        this.leadId = leadId;
        this.userId = userId;
        this.createdAt = createdAt;
        this.lead = lead;
        this.user = user;
    }
}
