# 🏥 ClinicOS --- Enterprise Clinic Management System

```{=html}
<p align="center">
```
`<b>`{=html}Production-Ready • Role-Based • Secure • Layered
Architecture • PostgreSQL Powered`</b>`{=html}
```{=html}
</p>
```

------------------------------------------------------------------------

# 🚀 Overview

ClinicOS is a **full-scale enterprise-grade Clinic Management System**
built with:

-   ⚙ Spring Boot 3
-   🔐 Spring Security (RBAC + BCrypt)
-   🗄 PostgreSQL
-   🧠 Hibernate / JPA
-   🎨 Thymeleaf + Bootstrap 5
-   🧪 JUnit + Mockito
-   📦 Maven
-   🐳 Docker Ready

This system enables clinics to manage:

-   👨‍💼 Admin operations
-   👨‍⚕️ Doctor workflows
-   🧑‍💻 Patient portal
-   📅 Appointment lifecycle
-   💊 Prescription management

Designed following **industry best practices** and clean layered
architecture.

------------------------------------------------------------------------

# 🧱 Architecture

    Controller Layer
            ↓
    Service Layer
            ↓
    Repository Layer
            ↓
    PostgreSQL Database

-   Separation of concerns
-   Transactional services
-   Role-based authorization
-   Clean MVC pattern
-   Production-ready configuration

------------------------------------------------------------------------

# 🔐 Security Model

-   BCrypt password hashing
-   Role-Based Access Control
-   CSRF protection
-   Custom login page
-   Session invalidation on logout

Roles:

-   ROLE_ADMIN
-   ROLE_DOCTOR
-   ROLE_PATIENT

------------------------------------------------------------------------

# 📊 Features

## 👨‍💼 Admin

-   Manage doctors
-   Manage patients
-   Dashboard analytics
-   Secure role-restricted endpoints

## 👨‍⚕️ Doctor

-   View appointments
-   Approve/reject bookings
-   Prescribe medications
-   View assigned patients

## 🧑 Patient

-   Register securely
-   Book appointments
-   View prescriptions
-   Manage profile

------------------------------------------------------------------------

# 🗄 Database Design

## Users Table

-   id (PK)
-   email (unique)
-   password (BCrypt encoded)
-   role

## Doctors Table

-   id (PK)
-   name
-   specialization
-   contact
-   user_id (FK)

## Patients Table

-   id (PK)
-   name
-   phone
-   medical_history
-   user_id (FK)

## Appointments Table

-   id (PK)
-   appointment_time
-   status (ENUM)
-   doctor_id (FK)
-   patient_id (FK)

## Medications Table

-   id (PK)
-   name
-   dosage
-   frequency
-   prescribed_date
-   doctor_id (FK)
-   patient_id (FK)

------------------------------------------------------------------------

# 🛠 Tech Stack

  Layer      Technology
  ---------- -----------------
  Backend    Spring Boot 3
  Security   Spring Security
  ORM        Hibernate / JPA
  Database   PostgreSQL
  Frontend   Thymeleaf
  UI         Bootstrap 5
  Build      Maven
  Java       17

------------------------------------------------------------------------

# 🐳 Docker Support

Build image:

    docker build -t clinicos .

Run container:

    docker run -p 8085:8085 clinicos

------------------------------------------------------------------------

# 🧪 Running Tests

    mvn test

Includes: - Unit tests - Service layer tests - Mock repository testing

------------------------------------------------------------------------

# 🚀 Run Locally

    mvn clean spring-boot:run

Access:

http://localhost:8085

------------------------------------------------------------------------

# 📦 Production Considerations

-   Externalized configuration
-   Environment-based DB setup
-   Docker-compatible
-   Stateless session management possible
-   PostgreSQL production ready

------------------------------------------------------------------------

# 📌 Why This Project Stands Out

-   Clean layered architecture
-   Real-world RBAC implementation
-   Secure authentication model
-   Relational database mapping
-   Enterprise-style structure
-   Resume-level backend engineering
-   YouTube demo ready

------------------------------------------------------------------------

# 📈 Future Enhancements

-   JWT authentication
-   Microservices version
-   REST API documentation (Swagger)
-   CI/CD pipeline
-   Kubernetes deployment
-   Caching layer (Redis)
-   Email notifications

------------------------------------------------------------------------

# 👤 Author

Dinesh Chandra\
GitHub: https://github.com/TheComputationalCore\
YouTube: https://www.youtube.com/@TheComputationalCore

------------------------------------------------------------------------

# ⭐ If you found this project valuable, consider giving it a star.
