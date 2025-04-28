package com.example.demo.model;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "campaigns")
public class Campaign {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String type; // Email, SMS, Social Media
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // Active, Paused, Completed

    private Long leadId;

    public Campaign() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
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

	@Override
	public String toString() {
		return "Campaign [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + ", leadId=" + leadId
				+ "]";
	}

	public Campaign(Long id, String name, String description, String type, LocalDate startDate, LocalDate endDate,
			String status, Long leadId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.leadId = leadId;
	}

    // Getters and Setters
}
