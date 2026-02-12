::: {align="center"}
# 🏥 Clinic Management System

### Production-Grade Role-Based Healthcare Workflow Platform

![CI](https://github.com/TheComputationalCore/clinic-management-system/actions/workflows/ci.yml/badge.svg)
![CodeQL](https://github.com/TheComputationalCore/clinic-management-system/actions/workflows/codeql.yml/badge.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)
:::

------------------------------------------------------------------------

## 🎥 Full System Walkthrough

📺 **YouTube Demo:**\
👉 https://youtube.com/YOUR_VIDEO_LINK_HERE

------------------------------------------------------------------------

# 📌 Overview

The **Clinic Management System (CMS)** is a production-oriented,
multi-role healthcare management platform built with **Spring Boot,
PostgreSQL, Docker, and CI/CD automation**.

It demonstrates:

-   Clean layered architecture
-   Role-Based Access Control (RBAC)
-   Secure authentication (BCrypt)
-   Appointment lifecycle management
-   Prescription workflow
-   Containerized deployment
-   Continuous Integration & Security scanning

This is engineered as a structured backend system --- not just a CRUD
demo.

------------------------------------------------------------------------

# 🏗 Architecture

## 🔹 High-Level Architecture Diagram

> Ensure `architecture_diagram.svg` is placed in the repository root.

```{=html}
<p align="center">
```
`<img src="./architecture_diagram.svg" alt="Architecture Diagram" width="700"/>`{=html}
```{=html}
</p>
```
### Architectural Style

Layered Monolith:

Client → Controller → Service → Repository → Database

------------------------------------------------------------------------

# 🗂 Entity Relationship Diagram (ERD)

> Ensure `er_diagram.png` is placed in the repository root.

```{=html}
<p align="center">
```
`<img src="./er_diagram.png" alt="ER Diagram" width="700"/>`{=html}
```{=html}
</p>
```
### Core Entities

-   User
-   Doctor
-   Patient
-   Appointment
-   Prescription

### Relationships

-   One Doctor → Many Appointments\
-   One Patient → Many Appointments\
-   One Appointment → One Prescription

------------------------------------------------------------------------

# 🖥 System Screenshots

> Ensure all screenshots are placed inside `/screenshots/` directory.

------------------------------------------------------------------------

## 🔐 Authentication

```{=html}
<p align="center">
```
`<img src="./screenshots/login.png" width="600"/>`{=html} `<br/>`{=html}
`<img src="./screenshots/register.png" width="600"/>`{=html}
```{=html}
</p>
```

------------------------------------------------------------------------

## 🧑‍💼 Admin Dashboard

```{=html}
<p align="center">
```
`<img src="./screenshots/admin-dashboard.png" width="700"/>`{=html}
```{=html}
</p>
```
Capabilities:

-   Manage doctors
-   Manage patients
-   Administrative visibility

------------------------------------------------------------------------

## ⚕️ Doctor Dashboard

```{=html}
<p align="center">
```
`<img src="./screenshots/doctor-dashboard.png" width="700"/>`{=html}
```{=html}
</p>
```
Capabilities:

-   View appointments
-   Approve/reject bookings
-   Create prescriptions

------------------------------------------------------------------------

## 👤 Patient Dashboard

```{=html}
<p align="center">
```
`<img src="./screenshots/patient-dashboard.png" width="700"/>`{=html}
```{=html}
</p>
```
Capabilities:

-   Book appointments
-   View status
-   Access prescriptions

------------------------------------------------------------------------

## 📅 Appointment Workflow

```{=html}
<p align="center">
```
`<img src="./screenshots/appointments.png" width="700"/>`{=html}
```{=html}
</p>
```
Workflow:

1.  Patient books appointment\
2.  Doctor approves/rejects\
3.  Prescription created if needed

------------------------------------------------------------------------

# 🛠 Technology Stack

  Layer                   Technology
  ----------------------- -----------------
  Language                Java 17
  Framework               Spring Boot
  Security                Spring Security
  ORM                     Hibernate / JPA
  Database                PostgreSQL
  Frontend                Thymeleaf
  Styling                 Bootstrap 5
  Build Tool              Maven
  Containerization        Docker
  CI/CD                   GitHub Actions
  Static Analysis         CodeQL
  Dependency Monitoring   Dependabot

------------------------------------------------------------------------

# 🐳 Docker (Production Ready)

Multi-stage Docker build using Eclipse Temurin runtime.

## Build

``` bash
docker build -t clinic-management-system .
```

## Run

``` bash
docker run -p 8085:8085 clinic-management-system
```

Access:

    http://localhost:8085

------------------------------------------------------------------------

# 🔄 Continuous Integration

On every push:

-   Application build
-   Unit testing
-   Docker validation
-   Static security scanning (CodeQL)

------------------------------------------------------------------------

# 🔐 Security Design

-   BCrypt password hashing
-   Role-based endpoint authorization
-   CSRF protection
-   Secure session handling
-   Automated vulnerability scanning

------------------------------------------------------------------------

# 🧪 Testing

``` bash
mvn test
```

-   Service-layer unit tests
-   Business rule validation
-   Mock-based isolation testing

------------------------------------------------------------------------

# 📁 Project Structure

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

------------------------------------------------------------------------

# 📈 Engineering Evolution

This project evolved from:

https://github.com/TheComputationalCore/patient-system

Enhancements include:

-   Multi-role RBAC architecture
-   Admin dashboard
-   Appointment lifecycle
-   Dockerization
-   CI/CD automation
-   Security scanning
-   Structural refactoring

------------------------------------------------------------------------

# 🚀 Future Enhancements

-   REST API layer
-   Swagger/OpenAPI documentation
-   JWT authentication
-   Cloud deployment (AWS/GCP)
-   Observability & monitoring
-   Audit logging

------------------------------------------------------------------------

# 📜 License

MIT License © 2025 TheComputationalCore

------------------------------------------------------------------------

# 💼 For Recruiters

This project demonstrates:

-   Backend architectural clarity
-   Secure authentication design
-   Database modeling
-   DevOps discipline (CI/CD + Docker)
-   Clean Git evolution strategy
-   Production-conscious engineering approach
