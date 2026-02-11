package com.example.patient_system.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.patient_system.model.Doctor;
import com.example.patient_system.model.User;
import com.example.patient_system.repository.DoctorRepository;
import com.example.patient_system.repository.UserRepository;


@Configuration
@Profile("!test")
public class DataInitializer {

    @Bean
    CommandLineRunner initData(UserRepository userRepository,
                               DoctorRepository doctorRepository,
                               PasswordEncoder passwordEncoder) {

        return args -> {

            // =========================
            // 🔐 ADMIN USER
            // =========================
            if (!userRepository.existsByEmail("admin@clinic.com")) {

                User admin = new User();
                admin.setEmail("admin@clinic.com");
                admin.setPassword(passwordEncoder.encode("123456"));
                admin.setRole("ROLE_ADMIN");

                userRepository.save(admin);
                System.out.println("✅ Admin created: admin@clinic.com / 123456");
            }

            // =========================
            // 👨‍⚕️ DOCTOR SPECIALITIES
            // =========================

            List<String> specializations = List.of(
                    "Cardiologist",
                    "Dermatologist",
                    "Neurologist",
                    "Orthopedic",
                    "Pediatrician"
            );

            for (String specialization : specializations) {

                String email = specialization.toLowerCase().replace(" ", "") + "@clinic.com";

                if (!userRepository.existsByEmail(email)) {

                    // 🔐 Create User
                    User doctorUser = new User();
                    doctorUser.setEmail(email);
                    doctorUser.setPassword(passwordEncoder.encode("123456"));
                    doctorUser.setRole("ROLE_DOCTOR");

                    User savedUser = userRepository.save(doctorUser);

                    // 👨‍⚕️ Create Doctor Entity
                    Doctor doctor = new Doctor();
                    doctor.setUser(savedUser);

                    // ✅ REQUIRED NOW (because nullable = false)
                    doctor.setName(specialization + " Specialist");

                    doctor.setSpecialization(specialization);
                    doctor.setContact("9999999999");

                    doctorRepository.save(doctor);

                    System.out.println("✅ Doctor created: " + email + " / 123456");
                }
            }

        };
    }
}
