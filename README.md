# 🏥 Patient Management System

A modern **full‑stack** Spring Boot + Thymeleaf + MySQL web application for patient registration, secure login, appointments, medications, and profile management — built with Spring Security, JPA/Hibernate, and a responsive Bootstrap UI.

---

## 🚀 Highlights
- Secure authentication with **Spring Security + BCrypt**  
- Patient registration, profile management, and personalized dashboard  
- Appointments: view, book, and confirm with flash messages  
- Medications: add, list, and delete per-patient  
- Doctors module: list doctors and link appointments  
- CSRF-protected forms and layered MVC architecture

---

## 🧬 Tech Stack
**Backend:** Java 17, Spring Boot 3, Spring Security, Spring Data JPA  
**Frontend:** Thymeleaf, HTML5, CSS3, Bootstrap 5  
**Database:** MySQL (production) / H2 (for quick local runs)  
**Tools:** Maven, Postman, Git/GitHub

---

## 📁 Project Layout (short)
```
patient-system/
├── src/main/java/.../{controller,service,repository,model}
├── src/main/resources/{templates,static,application.properties}
├── screenshots/
└── pom.xml
```

---

## ⚙️ Quick Setup (short & safe)

### Requirements
- JDK 17, Maven, MySQL (or use H2 for quick tests)

### 1. Clone
```bash
git clone https://github.com/TheComputationalCore/patient-system.git
cd patient-system
```

### 2. Create database (MySQL)
```sql
CREATE DATABASE patient_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 3. Configure credentials
Open 

```src/main/resources/application.properties 
```

### 4. Build & run
```bash
mvn clean install -DskipTests
mvn spring-boot:run
```
App will be available at `http://localhost:8080` (or the port shown in logs).

---

## 🧪 Postman & API testing

**Postman screenshots (from `/screenshots/`):**

![Postman - Collection](./screenshots/screenshot_postman.png)  
![Postman - Encoded (colon)](./screenshots/screenshot%3Apostman.png)  
![Postman - Literal (colon)](./screenshots/screenshot:postman.png)


---

## 📸 UI & Database screenshots


### Authentication
![Login](./screenshots/login.png)
![Registration](./screenshots/registration.png)

### Dashboard & Home
![Homepage](./screenshots/homepage.png)
![Dashboard](./screenshots/dashboard.png)

### Appointments
![Appointments List](./screenshots/appointments.png)
![Book Appointment](./screenshots/book%20appointment.png)
![Appointment Success](./screenshots/appointment%20booked%20successfully.png)

### Medications
![Medication List](./screenshots/medication%20list.png)
![Add Medication](./screenshots/adding%20medication.png)

### Profile & DB
![User Profile](./screenshots/user%20profile.png)
![DB Overview 1](./screenshots/database%201.png)
![DB Overview 2](./screenshots/database%202.png)

---


## 📜 License & Contact
**License:** MIT — see `LICENSE` 


**Author:** Dinesh Chandra — TheComputationalCore  
- GitHub: https://github.com/TheComputationalCore  
- YouTube: https://www.youtube.com/@TheComputationalCore

---


