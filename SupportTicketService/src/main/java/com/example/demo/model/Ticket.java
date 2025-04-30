package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private String description;
    private String status;   // Open, In Progress, Resolved, Closed
    private String priority; // Low, Medium, High

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Long leadId; // Link to Lead

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getLeadId() {
		return leadId;
	}

	public void setLeadId(Long leadId) {
		this.leadId = leadId;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", subject=" + subject + ", description=" + description + ", status=" + status
				+ ", priority=" + priority + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", leadId="
				+ leadId + "]";
	}

	public Ticket(Long id, String subject, String description, String status, String priority, LocalDateTime createdAt,
			LocalDateTime updatedAt, Long leadId) {
		super();
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.leadId = leadId;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Constructor, Getters, Setters
}
