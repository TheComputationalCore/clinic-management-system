# 🏥 Clinic Management System

### Production-Grade, Role-Based Healthcare Workflow Platform

![CI](https://github.com/TheComputationalCore/clinic-management-system/actions/workflows/ci.yml/badge.svg)
![CodeQL](https://github.com/TheComputationalCore/clinic-management-system/actions/workflows/codeql.yml/badge.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

------------------------------------------------------------------------

## 🎥 Full System Walkthrough

📺 **YouTube Demo (End-to-End System Explanation)**\
👉 https://youtube.com/YOUR_VIDEO_LINK_HERE

------------------------------------------------------------------------

# 📌 Overview

The **Clinic Management System (CMS)** is a production-oriented,
multi-role healthcare management platform built using Spring Boot and
PostgreSQL.

This system demonstrates:

-   Clean layered architecture
-   Role-Based Access Control (RBAC)
-   Secure authentication using BCrypt
-   Appointment lifecycle management
-   Prescription workflow
-   Docker containerization
-   CI/CD with GitHub Actions
-   Static security scanning (CodeQL)
-   Dependency monitoring (Dependabot)

This is not a CRUD demo --- it reflects backend engineering discipline.

------------------------------------------------------------------------

# 🏗 High-Level Architecture

![Architecture Diagram](architecture_diagram.svg)

Layered Architecture:

Client → Controller → Service → Repository → Database

------------------------------------------------------------------------

# 🗂 Entity Relationship Diagram (ERD)

![ER Diagram](er_diagram.png)

Core Entities:

-   User
-   Doctor
-   Patient
-   Appointment
-   Prescription

------------------------------------------------------------------------

# 🖥 System Screenshots

> Place all images inside `/screenshots/`

## 🔐 Authentication

![Login](screenshots/login.png) ![Register](screenshots/register.png)

## 🧑‍💼 Admin Dashboard

![Admin Dashboard](screenshots/admin-dashboard.png)

## ⚕️ Doctor Dashboard

![Doctor Dashboard](screenshots/doctor-dashboard.png)

## 👤 Patient Dashboard

![Patient Dashboard](screenshots/patient-dashboard.png)

## 📅 Appointment Workflow

![Appointments](screenshots/appointments.png)

------------------------------------------------------------------------

# 🛠 Technology Stack

-   Java 17
-   Spring Boot
-   Spring Security
-   Hibernate / JPA
-   PostgreSQL
-   Thymeleaf
-   Bootstrap 5
-   Maven
-   Docker
-   GitHub Actions
-   CodeQL
-   Dependabot

------------------------------------------------------------------------

# 🐳 Docker

Build:

docker build -t clinic-management-system .

Run:

docker run -p 8085:8085 clinic-management-system

Access:

http://localhost:8085

------------------------------------------------------------------------

# 🔄 Continuous Integration

On every push:

-   Build validation
-   Unit testing
-   Docker image validation
-   CodeQL security scanning

------------------------------------------------------------------------

# 🔐 Security Design

-   BCrypt password hashing
-   Role-based endpoint restriction
-   CSRF protection
-   Secure session handling
-   Static code analysis
-   Automated dependency monitoring

------------------------------------------------------------------------

# 🧪 Testing

mvn test

Service-layer unit tests with JUnit 5 & Mockito.

------------------------------------------------------------------------

# 📁 Project Structure

clinic-management-system/ │ ├── .github/workflows/ ├──
src/main/java/com/thecomputationalcore/cms/ ├── src/main/resources/ ├──
architecture_diagram.svg ├── er_diagram.png ├── screenshots/ ├──
Dockerfile └── pom.xml

------------------------------------------------------------------------

# 📈 Engineering Evolution

This project evolved from:

https://github.com/TheComputationalCore/patient-system

Enhancements include:

-   Multi-role RBAC system
-   Admin dashboard
-   Appointment lifecycle
-   Dockerization
-   CI/CD automation
-   Security scanning
-   Structural refactoring

------------------------------------------------------------------------

# 🚀 Future Enhancements

-   REST API endpoints
-   Swagger documentation
-   JWT authentication
-   Cloud deployment
-   Audit logging
-   Observability integration

------------------------------------------------------------------------

# 📜 License

MIT License © 2025 TheComputationalCore

------------------------------------------------------------------------

# 💼 For Recruiters

This project showcases:

-   System design understanding
-   Role-based security implementation
-   Database modeling
-   Docker & CI/CD workflows
-   Clean Git evolution history
-   Production-oriented architecture
