# Patient System

[![Build](https://github.com/TheComputationalCore/patient-system/actions/workflows/ci.yml/badge.svg)](https://github.com/TheComputationalCore/patient-system/actions)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)

A **Spring Boot + Thymeleaf** based patient management system for handling appointments, medications, user authentication, and patient profiles.

---

## 📸 Screenshots

Place your screenshots inside the `screenshots/` folder.

Example:
![Dashboard](screenshots/dashboard.png)

---

## ✨ Features

- 👤 User registration & login (Spring Security + BCrypt)
- 📅 Book and manage appointments
- 💊 Track medications & medical history
- 🖥️ Thymeleaf-based UI
- 🛢️ Supports H2, MySQL, PostgreSQL
- 🔧 Configurable via `application.properties`
- 🐳 Optional Docker support

---

## 🚀 Quick Start (Local Setup)

### **Prerequisites**
- **Java 17+**
- **Maven 3.6+**
- (Optional) **Docker**

### 1️⃣ Clone the repository

```bash
git clone https://github.com/TheComputationalCore/patient-system.git
cd patient-system
```

### 2️⃣ Build the project

```bash
./mvnw clean package
```

### 3️⃣ Run with H2 (Recommended for Development)

Create or update this file:

`src/main/resources/application.properties`

```properties
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

Then start the app:

```bash
./mvnw spring-boot:run
```

Visit:

**http://localhost:8085**

---

## 🗄️ Database Configuration Examples

### **MySQL**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/patient_system
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### **PostgreSQL**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/patient_system
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

## 🐳 Docker Support

### Build the image
```bash
docker build -t patient-system:latest .
```

### Run the container
```bash
docker run -p 8085:8085 --env-file .env patient-system:latest
```

You can create a `.env` file to set your DB environment variables.

---

## 🧪 Running Tests

```bash
./mvnw test
```

---

## 🔄 Continuous Integration (CI)

A GitHub Actions workflow automatically runs:

- Maven build  
- Tests  
- Branch validation  

You can find it under:  
`.github/workflows/ci.yml`

---

## 🤝 Contributing

Contributions are welcome! Please read `CONTRIBUTING.md` for:

- How to report bugs  
- Coding style  
- Opening pull requests  
- Branch naming conventions  

---

## 📄 License

This project is licensed under the **MIT License**.  
See `LICENSE` for details.

---

