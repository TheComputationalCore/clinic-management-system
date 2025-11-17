# 🚑 Patient Management System

![License](https://img.shields.io/github/license/TheComputationalCore/patient-system)
![Stars](https://img.shields.io/github/stars/TheComputationalCore/patient-system)
![Forks](https://img.shields.io/github/forks/TheComputationalCore/patient-system)
![Issues](https://img.shields.io/github/issues/TheComputationalCore/patient-system)

A modern **Patient Management System** built with **Spring Boot**, **Spring Security**, **Thymeleaf**, and **Spring Data JPA**.  
Designed for clinics and healthcare teams to efficiently manage **patients, appointments, medications, and medical profiles** with a secure, clean, and user-friendly interface.

---

## ✨ Features

### 👤 User Accounts & Security
- User registration & login  
- Password hashing with BCrypt  
- Session-based authentication (Spring Security)

### 🏥 Patient Management
- Create, update, delete patient profiles  
- Medical information & history tracking  
- Easy patient search

### 📅 Appointment Handling
- Book, edit, cancel appointments  
- View appointment history

### 💊 Medication Tracking
- Add and manage medications  
- View prescription details

### 🖥️ Modern UI (Thymeleaf + Bootstrap)
- Clean responsive design  
- Intuitive navigation  

### 🛢️ Database Support
- **H2 (in-memory)** — ideal for development  
- **MySQL**  
- **PostgreSQL**

### 🐳 Docker Friendly
- Build and run using Docker  
- `.env` support for DB credentials  

---

# 📸 Screenshots

All screenshots referenced below are stored inside the repository at **`/screenshots/`**.

### 🏠 Main UI Screens
Dashboard  
![Dashboard](screenshots/dashboard.png)

Homepage  
![Homepage](screenshots/homepage.png)

Registration  
![Registration](screenshots/registration.png)

Logout  
![Logout](screenshots/logout.png)

---


# 🧩 Tech Stack

| Layer | Technology |
|-------|------------|
| Backend | Spring Boot, Spring MVC, Spring Data JPA |
| Frontend | Thymeleaf, Bootstrap 5 |
| Security | Spring Security, BCrypt |
| Database | H2, MySQL, PostgreSQL |
| Build Tool | Maven |
| Containerization | Docker |

---

# 📁 Project Structure

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
├── Dockerfile
└── README.md
```

---

# 🚀 Quick Start

## ✅ Prerequisites
- Java **17+**
- Maven **3.6+**
- (Optional) Docker

---

## 1️⃣ Clone the Repository

```bash
git clone https://github.com/TheComputationalCore/patient-system.git
cd patient-system
```

---

## 2️⃣ Build the Application

```bash
./mvnw clean package
```

---

## 3️⃣ Run with H2 (Recommended)

Edit:

```
src/main/resources/application.properties
```

Add (example):

```
server.port=8085

spring.datasource.url=jdbc:h2:mem:patient_system
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.thymeleaf.cache=false
```

Run the app:

```bash
./mvnw spring-boot:run
```

Open in your browser:

- http://localhost:8085  
- H2 console: http://localhost:8085/h2-console

---

# 🗄️ Database Configuration Examples

## MySQL

```
spring.datasource.url=jdbc:mysql://localhost:3306/patient_system
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

## PostgreSQL

```
spring.datasource.url=jdbc:postgresql://localhost:5432/patient_system
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

# 🐳 Docker Support

### Build Image

```bash
docker build -t patient-system:latest .
```

### Run Container

```bash
docker run -p 8085:8085 --env-file .env patient-system:latest
```

Add database credentials to `.env`:

```
DB_URL=jdbc:mysql://...
DB_USERNAME=...
DB_PASSWORD=...
```

---

# 🧪 Running Tests

```bash
./mvnw test
```

---

# 🤝 Contributing

Contributions are welcome! Please read `CONTRIBUTING.md` for details on reporting issues, coding style, and opening pull requests.

---

# 📜 License

This project is licensed under the **MIT License**. See `LICENSE` for details.

---

# 📬 Contact

**Dinesh Chandra — TheComputationalCore**  
GitHub: https://github.com/TheComputationalCore  
YouTube: https://www.youtube.com/@TheComputationalCore
