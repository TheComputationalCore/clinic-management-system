package com.example.patient_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.patient_system.model.Doctor;
import com.example.patient_system.model.User;
import com.example.patient_system.repository.DoctorRepository;
import com.example.patient_system.repository.UserRepository;

@Service
@Transactional
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DoctorService(DoctorRepository doctorRepository,
                         UserRepository userRepository,
                         PasswordEncoder passwordEncoder) {
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // =====================================
    // GET ALL DOCTORS
    // =====================================
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // =====================================
    // GET DOCTOR BY ID
    // =====================================
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
    }

    // =====================================
    // FIND DOCTOR BY EMAIL
    // =====================================
    public Optional<Doctor> findByEmail(String email) {
        if (email == null) return Optional.empty();
        return doctorRepository.findByUserEmail(email.toLowerCase().trim());
    }

    // =====================================
    // GET CURRENT LOGGED-IN DOCTOR
    // =====================================
    public Optional<Doctor> getCurrentLoggedInDoctor() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null ||
            !authentication.isAuthenticated() ||
            authentication.getPrincipal().equals("anonymousUser")) {

            return Optional.empty();
        }

        String email = authentication.getName();
        return findByEmail(email);
    }

    // =====================================
    // ADMIN CREATES DOCTOR (User + Doctor)
    // =====================================
    public Doctor createDoctor(Doctor doctor) {

        if (doctor == null || doctor.getUser() == null) {
            throw new IllegalArgumentException("Invalid doctor data");
        }

        String email = doctor.getUser().getEmail().toLowerCase().trim();

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Create login user
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(doctor.getUser().getPassword()));
        user.setRole("ROLE_DOCTOR");

        User savedUser = userRepository.save(user);

        doctor.setUser(savedUser);

        return doctorRepository.save(doctor);
    }

    // =====================================
    // DELETE DOCTOR (with linked User)
    // =====================================
    public void deleteDoctor(Long doctorId) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        userRepository.delete(doctor.getUser());
        doctorRepository.delete(doctor);
    }
}
