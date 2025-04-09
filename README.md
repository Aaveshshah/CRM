# CRM Microservices API Documentation

This project is a microservices-based CRM system built using Spring Boot and PostgreSQL. Each microservice is responsible for a specific module and communicates via REST APIs.

---

## 🧑‍💼 User Management Service (`localhost:8080/api/users`)

```
POST    /api/users                      - Create new user
GET     /api/users                      - Get all users (with leads if active)
GET     /api/users/{id}                 - Get user by ID (with leads if active)
GET     /api/users/username/{username} - Get user by username (with leads if active)
GET     /api/users/role/{role}         - Get users by role (with leads if active)
GET     /api/users/active              - Get all active users
PUT     /api/users/{id}                - Update user details
DELETE  /api/users/{id}                - Delete user by ID
PUT     /api/users/deactivate/{id}     - Deactivate user
```

---

## 📋 Lead Management Service (`localhost:8081/api/leads`)

```
GET     /api/leads                            - Get all leads (with contacts)
GET     /api/leads/{id}                       - Get lead by ID (with contacts)
GET     /api/leads/userid/{userId}            - Get all leads assigned to a user
POST    /api/leads                            - Create a new lead
PUT     /api/leads/{leadId}/assign/{userId}   - Assign lead to a user
```

---

## 📞 Contact Service (`localhost:8082/api/contacts`)

```
GET     /api/contacts                   - Get all contacts
POST    /api/contacts                   - Create a new contact
GET     /api/contacts/lead/{leadId}     - Get contacts by lead ID
DELETE  /api/contacts/{id}              - Delete a contact
```

---

## 📈 Sales Automation Service (`localhost:8083/api/sales`)

```
POST    /api/sales                      - Create new sales record
GET     /api/sales                      - Get all sales (includes user & lead info)
GET     /api/sales/user/{userId}        - Get all sales for a user
GET     /api/sales/lead/{leadId}        - Get all sales for a lead
```

---

## 📌 Database

All services use a common PostgreSQL database named `crm_db`.

---

## 🚀 Author

**Aavesh Shah** - Full Stack Developer | Spring Boot | Microservices | Angular | SQL

---
