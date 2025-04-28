package com.example.demo.DTOclasses;

public class UserDTO {
	 private Long id;
	    private String username;
	    private String email;
	    private String phone;
	    private String role;
	    private boolean active;
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
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		@Override
		public String toString() {
			return "UserDTO [id=" + id + ", username=" + username + ", email=" + email + ", phone=" + phone + ", role="
					+ role + ", active=" + active + "]";
		}
		public UserDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public UserDTO(Long id, String username, String email, String phone, String role, boolean active) {
			super();
			this.id = id;
			this.username = username;
			this.email = email;
			this.phone = phone;
			this.role = role;
			this.active = active;
		} 

}
