# 🏥 Clinic Management System Pro

### Enterprise-Grade Full-Stack Healthcare Platform

![Java](https://img.shields.io/badge/Java-17-orange) ![Spring
Boot](https://img.shields.io/badge/Spring%20Boot-3.2-brightgreen)
![Security](https://img.shields.io/badge/Spring%20Security-Enabled-success)
![Database](https://img.shields.io/badge/PostgreSQL-14-blue)
![Build](https://img.shields.io/badge/Maven-Build-red)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

------------------------------------------------------------------------

## 🚀 Overview

Clinic Management System Pro is a production-ready, enterprise-level
healthcare management platform built with modern backend engineering
principles.

Designed using Layered Architecture, Role-Based Access Control, and
Secure Authentication, this system enables seamless collaboration
between:

-   👨‍💼 Admins
-   👨‍⚕️ Doctors
-   🧑 Patients

Built for scalability, maintainability, and real-world deployment.

------------------------------------------------------------------------

# ✨ Core Features

## 🔐 Authentication & Security

-   Spring Security 6
-   BCrypt password hashing
-   Role-Based Authorization (RBAC)
-   CSRF Protection
-   Secure session management

## 👨‍💼 Admin Capabilities

-   Manage doctors
-   Manage patients
-   View system statistics
-   Dashboard analytics

## 👨‍⚕️ Doctor Capabilities

-   View appointments
-   Approve / Reject bookings
-   Prescribe medications
-   View patient history

## 🧑 Patient Capabilities

-   Register & login
-   Book appointments
-   View prescriptions
-   Manage profile

------------------------------------------------------------------------

# 🏗 Architecture

Controller Layer → Service Layer → Repository Layer → Database

-   Clean separation of concerns
-   Transactional service layer
-   JPA/Hibernate ORM mapping
-   REST + MVC hybrid design

------------------------------------------------------------------------

# 🛠 Tech Stack

  Layer        Technology
  ------------ -------------------
  Backend      Spring Boot 3
  Security     Spring Security
  ORM          Hibernate / JPA
  Database     PostgreSQL
  Frontend     Thymeleaf
  UI           Bootstrap 5
  Build Tool   Maven
  Testing      JUnit 5 + Mockito

------------------------------------------------------------------------

# 📸 Screenshots

## 🏠 Homepage

![Homepage](assets/homepage.png)

## 🔐 Login Page

![Login](assets/login-page.png)

## 👨‍💼 Admin Dashboard

![Admin](assets/admin-dashboard.png)

## 👨‍⚕️ Doctor Dashboard

![Doctor](assets/doctor-dashboard.png)

## 🧑 Patient Dashboard

![Patient](assets/patient-dashboard.png)

## 📅 Appointment Booking

![Booking](assets/booking-appointment.png)

## 💊 Prescriptions

![Prescriptions](assets/prescriptions.png)

------------------------------------------------------------------------

# 🗄 Database Schema Overview

Tables: - users - doctors - patients - appointments - medications

Relational mapping: - One-to-One (User ↔ Doctor/Patient) - One-to-Many
(Doctor → Appointments) - Many-to-One (Medication → Doctor & Patient)

------------------------------------------------------------------------

# 🐳 Docker Deployment

Build: docker build -t clinic-system .

Run: docker run -p 8085:8085 clinic-system

------------------------------------------------------------------------

# 🚀 Local Setup

Clone: git clone
https://github.com/TheComputationalCore/clinic-management-system.git

Run: mvn spring-boot:run

Access: http://localhost:8085

------------------------------------------------------------------------

# 🧪 Testing

mvn test

Includes: - Service layer unit tests - Repository validation - Security
configuration checks

------------------------------------------------------------------------

# 🔮 Roadmap

-   JWT Authentication
-   Swagger Documentation
-   CI/CD Pipeline
-   Cloud Deployment Guide

------------------------------------------------------------------------

# 👤 Author

Dinesh Chandra\
GitHub: https://github.com/TheComputationalCore\
YouTube: https://www.youtube.com/@TheComputationalCore

------------------------------------------------------------------------

# 📜 License

MIT License

------------------------------------------------------------------------

⭐ If you find this project valuable, consider giving it a star!
