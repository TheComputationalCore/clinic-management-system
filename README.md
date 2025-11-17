# 🏥 Patient Management System
A modern full-stack Spring Boot + Thymeleaf + MySQL application for managing patients, appointments, medications, and profiles — built with secure authentication and a clean UI.

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
- Spring Security (Auth + CSRF)
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

---

## ⚙️ Setup Instructions

### Prerequisites
- Java 17 SDK installed
- Maven 3.x
- MySQL server
- (Optional) Postman for API testing

### 1. Clone the repository
```bash
git clone https://github.com/TheComputationalCore/patient-system.git
cd patient-system
```

### 2. Create the MySQL database
1. Start your MySQL server.
2. Run:
```sql
CREATE DATABASE patient_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 3. Configure application properties
Open `src/main/resources/application.properties` (or `application.yml`) and set the following properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/patient_system?useSSL=false&serverTimezone=UTC
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=true

server.port=8080
```

> Replace `YOUR_DB_USERNAME` and `YOUR_DB_PASSWORD` with your credentials. For production, use environment variables or encrypted secrets — do not commit plaintext credentials.

### 4. Build the project
```bash
mvn clean install -DskipTests
```

### 5. Run the application
```bash
mvn spring-boot:run
```
Or run the generated jar:
```bash
java -jar target/patient-system-0.0.1-SNAPSHOT.jar
```

### 6. Open the app
Visit: http://localhost:8080

---

## 🧪 API Testing (Postman)

API requests used during development are illustrated with screenshots in `/screenshots`. Typical Postman screenshots to include (make sure your actual filenames match the ones below; replace if necessary):

- `postman_collection.png` — Postman collection overview  
- `postman_request_login.png` — Login request + response  
- `postman_request_add_medication.png` — Add medication POST request + response  
- `postman_response_appointments.png` — GET appointments response

### Postman Screenshots
![Postman Collection](./screenshots/postman_collection.png)
![Postman - Login Request](./screenshots/postman_request_login.png)
![Postman - Add Medication](./screenshots/postman_request_add_medication.png)
![Postman - Appointments Response](./screenshots/postman_response_appointments.png)

> If your Postman screenshot filenames are different, rename the files in the `/screenshots` folder to the exact names above or update these image paths accordingly.

---

## 📸 UI & DB Screenshots
All UI and DB screenshots are stored in `/screenshots`. Below are embedded examples using expected filenames. If your actual files have spaces, the README uses URL-encoded paths (spaces replaced with `%20`) and also supports quoted paths.

### 🔐 Login & Registration
![Login](./screenshots/login.png)
![Registration](./screenshots/registration.png)

### 🏠 Homepage & Dashboard
![Homepage](./screenshots/homepage.png)
![Dashboard](./screenshots/dashboard.png)

### 🗓️ Appointments
![Appointments List](./screenshots/appointments.png)
![Book Appointment](./screenshots/book%20appointment.png)
![Appointment Success](./screenshots/appointment%20booked%20successfully.png)

### 💊 Medications
![Medication List](./screenshots/medication%20list.png)
![Add Medication](./screenshots/adding%20medication.png)

### 👨‍⚕️ User Profile
![User Profile](./screenshots/user%20profile.png)

### 🛢️ Database Screens
![DB 1](./screenshots/database%201.png)
![DB 2](./screenshots/database%202.png)
![DB 3](./screenshots/database%203.png)
![DB 4](./screenshots/database%204.png)
![DB 5](./screenshots/database%205.png)

---

## 🏗️ Future Enhancements
- Doctor login portal & roles (doctor, admin)  
- Email notifications (SMTP / SendGrid)  
- JWT token-based API for mobile clients  
- Deploy to AWS / Render / Railway / Heroku  
- Pagination, filtering & sorting on lists  
- Automated tests & CI/CD

---

## 📜 License
MIT License — see `LICENSE` file.

---

## ✉️ Contact
**Dinesh Chandra — TheComputationalCore**  
- GitHub: https://github.com/TheComputationalCore  
- YouTube: https://www.youtube.com/@TheComputationalCore

---

**Notes & next steps**
1. Double-check actual screenshot filenames in your `screenshots/` folder.  
2. If any filenames differ, either rename the files to match the paths used above, or tell me the exact filenames and I will regenerate the README accordingly.

