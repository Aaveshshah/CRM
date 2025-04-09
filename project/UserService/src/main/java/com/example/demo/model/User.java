package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String username;

    private String email;  

   
    private String phone;

    private String role; // Admin, Sales, Support, etc.
    
    private boolean isActive = true;

   
    public boolean isActive() {
		return isActive;
	}

    @Transient
    private List<Leads> leads=new ArrayList<Leads>();

	public User(Long id, String username, String email, String phone, String role, boolean isActive,
			List<Leads> leads) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.isActive = isActive;
		this.leads = leads;
	}


	public List<Leads> getLeads() {
		return leads;
	}


	public void setLeads(List<Leads> leads) {
		this.leads = leads;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    

	public User(Long id, String username, String email, String phone, String role, boolean isActive) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.isActive= isActive;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", phone=" + phone + ", role=" + role
				+ ", isActive=" + isActive + ", leads=" + leads + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


}
