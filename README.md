
# Patient System

A complete Patient Management System built with **Spring Boot**, **Spring Data JPA**, **Spring Security**, **Thymeleaf**, and **MySQL**.  
Includes user registration/login, appointments, medications, and a responsive dashboard.

---

## 🚀 Features

- ✔️ Patient Registration & Login (Spring Security)
- ✔️ Appointment Booking & Management  
- ✔️ Medication Tracking  
- ✔️ User Profile  
- ✔️ Spring Boot MVC + Service + Repository Architecture  
- ✔️ MySQL Database using JPA/Hibernate  
- ✔️ Thymeleaf Frontend Templates  

---

## 🧩 Tech Stack

| Layer      | Technology |
|-----------|------------|
| Backend   | Spring Boot 3, Spring Security, Spring Data JPA |
| Frontend  | Thymeleaf, Bootstrap |
| Database  | MySQL |
| Build Tool | Maven |

---

## 📁 Project Structure

```
patient-system/
├── src/
│   ├── main/java/.../controller
│   ├── main/java/.../service
│   ├── main/java/.../repository
│   ├── main/java/.../model
│   └── main/resources/
│       ├── templates/
│       └── static/
├── screenshots/
└── README.md
```

---

## ⚙️ Quickstart

### 1️⃣ Clone the Repository
```
git clone https://github.com/TheComputationalCore/patient-system.git
cd patient-system
```

### 2️⃣ Create MySQL Database
```
CREATE DATABASE patient_system;
```

### 3️⃣ Configure Database Credentials  
Edit the file:

```
src/main/resources/application.properties
```

### 4️⃣ Build & Run
```
mvn clean install
mvn spring-boot:run
```

### 5️⃣ Access the Application  
```
http://localhost:8080
```

---

## 🌐 Endpoints Summary

| Feature | URL | Access |
|--------|------|--------|
| Home | `/` | Public |
| Register | `/register` | Public |
| Login | `/login` | Public |
| Appointments | `/appointments` | Authenticated |
| Medications | `/medications` | Authenticated |
| Logout | `/logout` | Authenticated |

---

## 📸 Screenshots

(All images stored in `/screenshots/` folder)

- Dashboard – `dashboard.png`
- Registration – `registration.png`
- Login – `login.png`
- Logout – `logout.png`
- Homepage – `homepage.png`
- Add Medication – `adding medication.png`
- Medication List – `medication list.png`
- Book Appointment – `booking an appointment.png`
- Appointment Success – `appointment booked successfully.png`
- User Profile – `user profile.png`
- Database Views – `database 1.png`, `database 2.png`, `database 3.png`, `database 4.png`, `database 5.png`

---

## 🚀 Future Improvements

- Add admin roles  
- Add pagination  
- Add advanced search filters  
- Add REST API layer  
- Add unit tests  
- Docker deployment  

---

## ✉️ Contact

**Dinesh Chandra — TheComputationalCore**  
GitHub: https://github.com/TheComputationalCore  
