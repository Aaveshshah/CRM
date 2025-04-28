package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales_records")
public class SalesRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dealName;
    private Double amount;
    private String status;
    private Long leadId;
    private Long userId;
    private LocalDateTime createdAt = LocalDateTime.now();
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
	@Override
	public String toString() {
		return "SalesRecord [id=" + id + ", dealName=" + dealName + ", amount=" + amount + ", status=" + status
				+ ", leadId=" + leadId + ", userId=" + userId + ", createdAt=" + createdAt + ", getId()=" + getId()
				+ ", getDealName()=" + getDealName() + ", getAmount()=" + getAmount() + ", getStatus()=" + getStatus()
				+ ", getLeadId()=" + getLeadId() + ", getUserId()=" + getUserId() + ", getCreatedAt()=" + getCreatedAt()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public SalesRecord(Long id, String dealName, Double amount, String status, Long leadId, Long userId,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.dealName = dealName;
		this.amount = amount;
		this.status = status;
		this.leadId = leadId;
		this.userId = userId;
		this.createdAt = createdAt;
	}
	public SalesRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}
