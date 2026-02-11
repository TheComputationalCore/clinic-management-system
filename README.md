```{=html}
<p align="center">
```
```{=html}
<h1 align="center">
```
🏥 Clinic Management System
```{=html}
</h1>
```
```{=html}
<p align="center">
```
`<strong>`{=html}Enterprise‑Grade Full Stack Spring Boot
Application`</strong>`{=html}`<br>`{=html} Role-Based Access Control •
Secure Authentication • Appointment Workflow • Prescription Management
```{=html}
</p>
```
```{=html}
</p>
```

------------------------------------------------------------------------

```{=html}
<p align="center">
```
`<img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge"/>`{=html}
`<img src="https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen?style=for-the-badge"/>`{=html}
`<img src="https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge"/>`{=html}
`<img src="https://img.shields.io/badge/Security-RBAC-red?style=for-the-badge"/>`{=html}
`<img src="https://img.shields.io/badge/License-MIT-lightgrey?style=for-the-badge"/>`{=html}
```{=html}
</p>
```

------------------------------------------------------------------------

# 🚀 Overview

The **Clinic Management System** is a production-ready healthcare
management platform built using **Spring Boot 3**, **Spring Security**,
**Thymeleaf**, and **PostgreSQL**.

It implements a clean **Layered Architecture**, secure authentication,
and complete workflow management between:

-   👨‍💼 Admin
-   👨‍⚕️ Doctors
-   🧑 Patients

This project demonstrates real-world backend architecture, security
practices, relational database modeling, and enterprise-level code
organization.

------------------------------------------------------------------------

# 🧱 Architecture

    Controller Layer  →  Service Layer  →  Repository Layer  →  PostgreSQL Database
            ↓
        Thymeleaf Views (Bootstrap UI)

### Architectural Highlights

-   Clean separation of concerns
-   Centralized authentication via User entity
-   Enum-based appointment status handling
-   Transactional service layer
-   Secure password encoding (BCrypt)
-   Role-based authorization rules

------------------------------------------------------------------------

# 🔐 Role-Based Access Control (RBAC)

  -----------------------------------------------------------------------
  Role                   Capabilities
  ---------------------- ------------------------------------------------
  ADMIN                  Manage doctors, manage patients, dashboard
                         analytics

  DOCTOR                 View appointments, approve/reject bookings,
                         prescribe medication

  PATIENT                Register, book appointments, view prescriptions,
                         manage profile
  -----------------------------------------------------------------------

Security implemented using:

-   Spring Security
-   BCrypt password hashing
-   Custom login page
-   CSRF protection
-   Authority-based route restrictions

------------------------------------------------------------------------

# 📸 Application Screenshots

## 🏠 Landing Page

![Homepage](assets/homepage.png)

## 📝 Registration

![Registration](assets/registration.png)

## 🔐 Login

![Login](assets/login-page.png)

------------------------------------------------------------------------

## 👨‍💼 Admin Panel

### Admin Dashboard

![Admin Dashboard](assets/admin-dashboard.png)

### Manage Doctors

![Manage Doctors](assets/manage-doctors.png)

### Manage Patients

![Patients](assets/patients.png)

### Add Doctor

![Add Doctor](assets/adding-doctor.png)

------------------------------------------------------------------------

## 🧑 Patient Experience

### Patient Dashboard

![Patient Dashboard](assets/patient-dashboard.png)

### Book Appointment

![Book Appointment](assets/booking-appointment.png)

### Appointment Confirmation

![Appointment List](assets/appointment-booking.png)

### Patient Profile

![Patient Profile](assets/patient-profile.png)

### Prescriptions

![Prescriptions](assets/prescriptions.png)

------------------------------------------------------------------------

## 👨‍⚕️ Doctor Experience

### Doctor Dashboard

![Doctor Dashboard](assets/doctor-dashboard.png)

### Patient Details & Prescribing

![Patient Details](assets/patient-details.png)

------------------------------------------------------------------------

# 🗄 Database Design

### Core Tables

-   users (authentication)
-   patients
-   doctors
-   appointments
-   medications

### Relationships

-   One-to-One: Patient ↔ User
-   One-to-One: Doctor ↔ User
-   Many-to-One: Appointment → Patient
-   Many-to-One: Appointment → Doctor
-   Many-to-One: Medication → Patient
-   Many-to-One: Medication → Doctor

------------------------------------------------------------------------

# 🛠 Tech Stack

  Layer      Technology
  ---------- -------------------
  Backend    Spring Boot 3.2.5
  Security   Spring Security
  ORM        Hibernate / JPA
  Database   PostgreSQL
  Frontend   Thymeleaf
  UI         Bootstrap 5
  Build      Maven
  Java       17

------------------------------------------------------------------------

# ⚙️ Running Locally

## 1️⃣ Clone Repository

``` bash
git clone https://github.com/TheComputationalCore/clinic-management-system.git
cd clinic-management-system
```

## 2️⃣ Configure Database

``` properties
spring.datasource.url=jdbc:postgresql://localhost:5432/clinic_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

## 3️⃣ Run Application

``` bash
./mvnw spring-boot:run
```

Access at:

    http://localhost:8085

------------------------------------------------------------------------

# 🧪 Testing

Run unit tests:

``` bash
./mvnw test
```

Includes:

-   Service layer tests
-   Mocked repository tests
-   Context load validation

------------------------------------------------------------------------

# 🐳 Docker (Optional)

``` bash
docker build -t clinic-ms .
docker run -p 8085:8085 clinic-ms
```

------------------------------------------------------------------------

# 📈 Why This Project Stands Out

✔ Enterprise layered architecture\
✔ Real RBAC implementation\
✔ Production-ready security\
✔ Clean UI & user experience\
✔ Enum-based workflow states\
✔ Proper relational modeling\
✔ Transactional service layer\
✔ Recruiter-ready GitHub project

------------------------------------------------------------------------

# 👤 Author

**Dinesh Chandra**\
GitHub: https://github.com/TheComputationalCore\
YouTube: https://www.youtube.com/@TheComputationalCore

------------------------------------------------------------------------

# 📜 License

MIT License
