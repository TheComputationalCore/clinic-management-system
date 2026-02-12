# 🏥 Clinic Management System

**Production-Grade Role-Based Healthcare Workflow Platform**

![CI](https://github.com/TheComputationalCore/clinic-management-system/actions/workflows/ci.yml/badge.svg)
![CodeQL](https://github.com/TheComputationalCore/clinic-management-system/actions/workflows/codeql.yml/badge.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

---

## 🎥 Demo

YouTube Walkthrough:  
https://youtube.com/YOUR_VIDEO_LINK_HERE

The demo covers:

- Architecture overview
- Authentication & RBAC
- Admin / Doctor / Patient workflows
- Appointment lifecycle
  

---

# 📌 Overview

The Clinic Management System (CMS) is a multi-role healthcare management platform built using Spring Boot and PostgreSQL.

It follows a clean layered architecture and incorporates security, containerization, and CI/CD automation.

This project demonstrates:

- Role-Based Access Control (RBAC)
- Secure authentication with BCrypt
- Appointment lifecycle management
- Prescription workflow
- Automated CI with security scanning

---

# 🏗 Architecture

![Architecture Diagram](architecture_diagram.svg)

## Architectural Style

Layered Monolith

Client → Controller → Service → Repository → Database

## Layer Responsibilities

### Controller Layer
- Handles HTTP requests
- Performs validation
- Returns Thymeleaf views

### Service Layer
- Contains business logic
- Manages transactions
- Enforces role rules

### Repository Layer
- JPA/Hibernate persistence
- Database abstraction

### Security Layer
- Spring Security 6
- Role-based endpoint authorization
- CSRF protection
- BCrypt password hashing

---

# 🗂 Entity Relationship Diagram (ERD)

![ER Diagram](er_diagram.png)

## Core Entities

- User  
- Doctor  
- Patient  
- Appointment  
- Prescription  

## Relationships

- One Doctor → Many Appointments  
- One Patient → Many Appointments  
- One Appointment → One Prescription  

---

# 🖥 Application Screenshots

## Login page

![Login](screenshots/login-page.png)  

## Patient Registration

![Register](screenshots/registration.png)

## 🧑‍💼 Admin Dashboard

![Admin Dashboard](screenshots/admin-dashboard.png)

Capabilities:
- Manage doctors
- Manage patients
- System-level visibility

## ⚕️ Doctor Dashboard

![Doctor Dashboard](screenshots/doctor-dashboard.png)

Capabilities:
- View appointments
- Approve or reject bookings
- Create prescriptions

## 👤 Patient Dashboard

![Patient Dashboard](screenshots/patient-dashboard.png)

Capabilities:
- Book appointments
- View appointment status
- Access prescriptions

## 📅 Appointment Workflow

![Appointments](screenshots/booking-appointment.png)

Workflow:
1. Patient books appointment
2. Doctor reviews and approves/rejects
3. Prescription is optionally generated

---

# 🛠 Technology Stack

| Category | Technology |
|----------|------------|
| Language | Java 17 |
| Framework | Spring Boot |
| Security | Spring Security |
| ORM | Hibernate / JPA |
| Database | PostgreSQL |
| Frontend | Thymeleaf |
| Styling | Bootstrap 5 |
| Build Tool | Maven |
| Containerization | Docker |
| CI/CD | GitHub Actions |
| Static Analysis | CodeQL |
| Dependency Monitoring | Dependabot |

---

# 🐳 Running with Docker (Local Containerized Setup)

The application is containerized using a multi-stage Docker build with Eclipse Temurin runtime.

## Build

```bash
docker build -t clinic-management-system .
```

## Run

```bash
docker run -p 8085:8085 clinic-management-system
```

Application runs at:

http://localhost:8085

---

# 🔄 Continuous Integration

On every push:

- Project build validation
- Unit test execution
- Docker image build verification
- Static security analysis via CodeQL

---

# 🔐 Security Design

- BCrypt password hashing
- Role-based endpoint restrictions
- CSRF protection enabled
- Secure session management
- Automated vulnerability scanning

---

# 🧪 Testing

```bash
mvn test
```

Includes:

- Service-layer unit tests
- Business rule validation
- Repository mocking via Mockito

---

# 📁 Project Structure

```
clinic-management-system/
│
├── .github/workflows/
│   ├── ci.yml
│   └── codeql.yml
│
├── src/main/java/com/thecomputationalcore/cms/
│   ├── config/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── security/
│   └── model/
│
├── src/main/resources/
│   ├── templates/
│   ├── static/
│   └── application.properties
│
├── architecture_diagram.svg
├── er_diagram.png
├── screenshots/
├── Dockerfile
└── pom.xml
```

---

# 📈 Engineering Evolution

This project evolved from:

https://github.com/TheComputationalCore/patient-system

Enhancements include:

- Multi-role RBAC architecture
- Admin dashboard
- Appointment lifecycle
- Dockerization
- CI/CD automation
- Security scanning
- Structural refactoring

---

# 🚀 Future Enhancements

- REST API endpoints
- Swagger/OpenAPI integration
- JWT-based authentication
- Cloud deployment (AWS/GCP)
- Observability & monitoring
- Audit logging

---

# 📜 License

MIT License © 2025 TheComputationalCore

---

# 💼 Recruiter Notes

This project demonstrates:

- Structured backend architecture
- Secure authentication implementation
- Database relationship modeling
- CI/CD automation
- Containerization best practices
- Clean Git evolution history
- Production-conscious engineering approach
