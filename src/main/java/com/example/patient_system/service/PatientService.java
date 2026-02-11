package com.example.patient_system.service;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.patient_system.model.Patient;
import com.example.patient_system.model.User;
import com.example.patient_system.repository.PatientRepository;
import com.example.patient_system.repository.UserRepository;

@Service
@Transactional
public class PatientService {

    private final PatientRepository patientRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public PatientService(PatientRepository patientRepository,
                          UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // =====================================================
    // REGISTER NEW PATIENT (Creates User + Patient)
    // =====================================================
    public Patient registerPatient(Patient patient) {

        if (patient == null || patient.getUser() == null) {
            throw new IllegalArgumentException("Invalid patient data");
        }

        String email = patient.getUser().getEmail();

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        email = email.toLowerCase().trim();

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists");
        }

        if (patient.getUser().getPassword() == null ||
            patient.getUser().getPassword().isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        // Create authentication user
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(patient.getUser().getPassword()));
        user.setRole("ROLE_PATIENT");

        User savedUser = userRepository.save(user);

        // Link patient to saved user
        patient.setUser(savedUser);

        return patientRepository.save(patient);
    }

    // =====================================================
    // GET PATIENT BY ID (Admin / Doctor)
    // =====================================================
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findByIdWithUser(id);
    }

    // =====================================================
    // FIND PATIENT BY EMAIL
    // =====================================================
    public Optional<Patient> findByEmail(String email) {

        if (email == null || email.isBlank()) {
            return Optional.empty();
        }

        return patientRepository.findByUserEmail(email.toLowerCase().trim());
    }

    // =====================================================
    // GET CURRENT LOGGED-IN PATIENT
    // =====================================================
    public Optional<Patient> getCurrentLoggedInPatient() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null ||
            !authentication.isAuthenticated() ||
            "anonymousUser".equals(authentication.getPrincipal())) {

            return Optional.empty();
        }

        String email = authentication.getName();

        return findByEmail(email);
    }

    // =====================================================
    // UPDATE CURRENT PATIENT PROFILE
    // =====================================================
    public Optional<Patient> updateCurrentPatientProfile(Patient updatedData) {

        if (updatedData == null) {
            return Optional.empty();
        }

        Optional<Patient> existingPatientOpt = getCurrentLoggedInPatient();

        if (existingPatientOpt.isEmpty()) {
            return Optional.empty();
        }

        Patient existingPatient = existingPatientOpt.get();

        // Update editable fields only
        if (updatedData.getName() != null) {
            existingPatient.setName(updatedData.getName());
        }

        existingPatient.setPhone(updatedData.getPhone());
        existingPatient.setMedicalHistory(updatedData.getMedicalHistory());

        return Optional.of(patientRepository.save(existingPatient));
    }

    // =====================================================
    // SAVE PATIENT (General Save)
    // =====================================================
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

}
