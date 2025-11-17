# 🏥 Patient Management System
A modern full-stack Spring Boot + Thymeleaf + MySQL application for managing patients, appointments, medications, and profiles — built with secure authentication and clean UI.

## 🚀 Features
### 🔐 User Management
- Patient Registration
- Secure Login (Spring Security + BCrypt)
- Personalized Dashboard

### 🗓️ Appointments
- View Appointments
- Book New Appointments
- Flash messages & confirmations

### 💊 Medications
- Add Medications
- Delete Medications
- Patient-specific medication list

### 👨‍⚕️ Doctors Module
- View Doctors
- Appointment ↔ Doctor linking

## 🧩 Architecture
- Spring Boot 3
- Spring Security
- JPA / Hibernate
- Thymeleaf + Bootstrap
- MVC layered structure
- MySQL

## 🧬 Tech Stack
| Layer     | Technology |
|-----------|------------|
| Backend   | Spring Boot 3, Spring Security, Spring Data JPA |
| Frontend  | Thymeleaf, HTML5, CSS3, Bootstrap |
| Database  | MySQL |
| Tools     | Maven, Postman, GitHub |
| Language  | Java 17 |

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

# 📸 Screenshots
All screenshots are inside `/screenshots`.

## 🔐 Login & Registration
![Login](./screenshots/login.png)
![Registration](./screenshots/registration.png)

## 🏠 Homepage & Dashboard
![Homepage](./screenshots/homepage.png)
![Dashboard](./screenshots/dashboard.png)

## 🗓️ Appointments
![Appointments](./screenshots/appointments.png)
![Book Appointment](./screenshots/book%20appointment.png)
![Appointment Success](./screenshots/appointment%20booked%20successfully.png)

## 💊 Medications
![Medication List](./screenshots/medication%20list.png)
![Add Medication](./screenshots/adding%20medication.png)

## 👨‍⚕️ User Profile
![User Profile](./screenshots/user%20profile.png)

## 🛢️ Database Screens
![DB 1](./screenshots/database%201.png)
![DB 2](./screenshots/database%202.png)
![DB 3](./screenshots/database%203.png)
![DB 4](./screenshots/database%204.png)
![DB 5](./screenshots/database%205.png)

## ⚙️ Setup Instructions
```bash
git clone https://github.com/TheComputationalCore/patient-system.git
cd patient-system
```

```sql
CREATE DATABASE patient_system;
```

Edit `application.properties` and run:
```bash
mvn clean install
mvn spring-boot:run
```

Visit: http://localhost:8080

## 🧪 API Testing
Postman screenshots included in `/screenshots`.

## 🏗️ Future Enhancements
- Doctor login
- Email notifications
- JWT authentication
- Deployment options
- Pagination & sorting

## 📜 License
MIT License

## ✉️ Contact
Dinesh Chandra — TheComputationalCore  
GitHub: https://github.com/TheComputationalCore  
YouTube: https://www.youtube.com/@TheComputationalCore
