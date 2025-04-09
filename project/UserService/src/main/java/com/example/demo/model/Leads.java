package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;



public class Leads {
	 
	    private Long id;
	    private String name;
	    private String email;
	    private String phone;
	    private String status;  // "New", "Contacted", "Converted"
	    private String source;  // "Website", "Referral", "Social Media"
	    private Long uid; // Stores User ID from User Service
	    private LocalDateTime createdAt;
	    private List<Contact> contact;
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
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public Long getUid() {
			return uid;
		}
		public void setUid(Long uid) {
			this.uid = uid;
		}
		public LocalDateTime getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}
		@Override
		public String toString() {
			return "Leads [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", status=" + status
					+ ", source=" + source + ", uid=" + uid + ", createdAt=" + createdAt + ", contact=" + contact + "]";
		}
		
		public Leads(Long id, String name, String email, String phone, String status, String source, Long uid,
				LocalDateTime createdAt, List<Contact> contact) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.status = status;
			this.source = source;
			this.uid = uid;
			this.createdAt = createdAt;
			this.contact = contact;
		}
		public Leads(Long id, String name, String email, String phone, String status, String source, Long uid,
				LocalDateTime createdAt) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.status = status;
			this.source = source;
			this.uid = uid;
			this.createdAt = createdAt;
		}
		public Leads() {
			super();
			// TODO Auto-generated constructor stub
		}
		public List<Contact> getContact() {
			return contact;
		}
		public void setContact(List<Contact> contact) {
			this.contact = contact;
		}
	     
	    
	    
	    
}
