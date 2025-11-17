
# 🏥 Patient Management System

A modern full‑stack **Spring Boot + Thymeleaf + MySQL** web application for patient registration, login, appointments, medications, and profile management — now presented with a clean UI and proper authentication using Spring Security.

This project is perfect for showcasing **backend engineering**, **full‑stack development**, and **secure application design** in your portfolio.

---

## 🚀 Features

### 🔐 User Management
- Patient Registration  
- Secure Login (Spring Security + BCrypt)  
- Personalized Dashboard  

### 🗓️ Appointments
- View Appointments  
- Book New Appointments  
- Confirmation & Flash Messages  

### 💊 Medications
- Add Medication  
- Delete Medication  
- Personalized list for each patient  

### 👨‍⚕️ Doctors Module
- View Doctors list  
- Appointment‑doctor linking  

### 🧩 Architecture
- Spring Boot 3  
- JPA / Hibernate  
- Thymeleaf with Bootstrap  
- MVC layered structure  
- MySQL secure connection  
- CSRF‑protected forms  

---

## 🧬 Tech Stack

| Layer        | Technology |
|--------------|------------|
| Backend      | Spring Boot 3, Spring Security, Spring Data JPA |
| Frontend     | Thymeleaf, HTML5, CSS3, Bootstrap |
| Database     | MySQL |
| Tools        | Maven, Postman, GitHub |
| Language     | Java 17 |

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

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/TheComputationalCore/patient-system.git
cd patient-system
```

### 2️⃣ Create MySQL Database
```sql
CREATE DATABASE patient_system;
```

### 3️⃣ Update Application Properties  
Edit:

```
src/main/resources/application.properties
```

Set:
```
spring.datasource.url=jdbc:mysql://localhost:3306/patient_system?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

### 4️⃣ Build & Run
```bash
mvn clean install
mvn spring-boot:run
```

### 5️⃣ Access the Application  
Open in browser:
```
http://localhost:8080
```

---

## 🧪 API Testing (POSTMAN)

This project was also tested using **Postman**.  
Below are API request screenshots included inside `/screenshots`.

---

# 📸 Screenshots

All screenshots are stored in the `screenshots/` folder.

## 🔐 Login & Registration
![Login](./screenshots/login.png)
![Registration](./screenshots/registration.png)

## 🏠 Homepage & Dashboard
![Homepage](./screenshots/homepage.png)
![Dashboard](./screenshots/dashboard.png)

## 🗓️ Appointments
![Appointments GET](./screenshots/screenshots:appointments-get.png)
![Book Appointment POST](./screenshots/screenshots:book-appointment-post.png)
![Appointment Success](./screenshots/appointment booked successfully.png)

## 💊 Medications
![Medication List](./screenshots/medication list.png)
![Adding Medication](./screenshots/adding medication.png)

## 👨‍⚕️ User Profile
![User Profile](./screenshots/user profile.png)

## 🛢️ Database Screens
![DB 1](./screenshots/database 1.png)
![DB 2](./screenshots/database 2.png)
![DB 3](./screenshots/database 3.png)
![DB 4](./screenshots/database 4.png)
![DB 5](./screenshots/database 5.png)

---

## 🏗️ Future Enhancements
- Doctor login portal  
- Email notifications  
- JWT authentication  
- Deploy on AWS / Render / Railway  
- Pagination & sorting  

---

## 📜 License
MIT License  

---

## ✉️ Contact
**Dinesh Chandra — TheComputationalCore**  
GitHub: https://github.com/TheComputationalCore  
YouTube: https://www.youtube.com/@TheComputationalCore  
