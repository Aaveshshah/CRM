# 📄 CRM Microservices Project

## 📚 Overview
This CRM (Customer Relationship Management) project is designed using **Microservices Architecture**.  
Each functionality is separated into independent services, allowing better scalability, maintenance, and deployment.

The project mainly consists of the following services:
- 👤 User Management Service
- 📞 Contact Management Service
- 🧲 Lead Management Service
- 💰 Sales Management Service
- 📢 Marketing Campaign Service
- 🛠️ Support Ticket Service

All services interact with each other using **REST APIs**.

---

## 🚀 Technologies Used
- **Backend:** Java 17+, Spring Boot, Spring Web, Spring Data JPA
- **Database:** MySQL
- **Communication:** REST APIs (via RestTemplate)
- **Tools:** Maven, Git, GitHub, Postman
- **Architecture:** Microservices Architecture

---

## 🧩 Services and APIs

### 1. 👤 User Management Service
**Handles:** Users who manage leads, contacts, sales, and campaigns.

| Method | Endpoint | Description |
|:------|:---------|:------------|
| POST | `/users/save` | Create a new user |
| GET | `/users/all` | Get all users |
| GET | `/users/{userId}` | Get user by ID (also returns assigned leads) |
| PUT | `/users/{userId}` | Update user details |
| DELETE | `/users/{userId}` | Delete user (soft delete - deactivate user) |
| GET | `/users/active` | Get all active users |

---

### 2. 📞 Contact Management Service
**Handles:** Contact information linked with leads.

| Method | Endpoint | Description |
|:------|:---------|:------------|
| POST | `/contacts/save` | Create a new contact |
| GET | `/contacts/new` | Get all contacts |
| GET | `/contacts/{contactId}` | Get contact by ID |
| PUT | `/contacts/{contactId}` | Update contact details |
| DELETE | `/contacts/{contactId}` | Delete contact |

---

### 3. 🧲 Lead Management Service
**Handles:** Lead tracking and assignment to users.

| Method | Endpoint | Description |
|:------|:---------|:------------|
| POST | `/leads/save` | Create a new lead |
| GET | `/leads/all` | Get all leads |
| GET | `/leads/{leadId}` | Get lead by ID |
| GET | `/leads/user/{userId}` | Get leads assigned to a user |
| PUT | `/leads/{leadId}` | Update lead details |
| DELETE | `/leads/{leadId}` | Delete lead |

---

### 4. 💰 Sales Management Service
**Handles:** Sales automation after leads are converted.

| Method | Endpoint | Description |
|:------|:---------|:------------|
| POST | `/sales/save` | Create a new sale |
| GET | `/sales/all` | Get all sales |
| GET | `/sales/{saleId}` | Get sale by ID |
| PUT | `/sales/{saleId}` | Update sale details |
| DELETE | `/sales/{saleId}` | Delete sale |

---

### 5. 📢 Marketing Campaign Service
**Handles:** Marketing campaigns to generate new leads.

| Method | Endpoint | Description |
|:------|:---------|:------------|
| POST | `/campaigns/save` | Create a new marketing campaign |
| GET | `/campaigns/all` | Get all campaigns |
| GET | `/campaigns/{campaignId}` | Get campaign by ID |
| PUT | `/campaigns/{campaignId}` | Update campaign details |
| DELETE | `/campaigns/{campaignId}` | Delete campaign |

---

### 6. 🛠️ Support Ticket Service  
**Handles:** Customer support tickets raised for any issue or inquiry.

| Method | Endpoint | Description |
|:------|:---------|:------------|
| POST  | `/tickets/save`         | Create a new support ticket |
| GET   | `/tickets/all`          | Get all support tickets |
| GET   | `/tickets/{ticketId}`   | Get support ticket by ID |
| GET   | `/tickets/user/{userId}`| Get tickets submitted by a user |
| PUT   | `/tickets/{ticketId}`   | Update ticket details or status |
| DELETE| `/tickets/{ticketId}`   | Delete a support ticket |

---

## 🔗 Communication Between Services
- **User Service** ↔ **Lead Service** (fetch user's leads)
- **Lead Service** ↔ **Contact Service** (lead linked with a contact)
- **Lead Service** ↔ **Sales Service** (when lead is converted to sale)
- **User Service** ↔ **Support Ticket Service** (manage tickets submitted by users)

Communication between services is done using **Spring's RestTemplate**.

---

## ✅ Project Status
- All services completed and tested successfully.
- Database structure and sample data created.
- Ready for further integration with frontend if required.
