package com.example.patient_system.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patient_system.model.Patient;
import com.example.patient_system.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // =====================================================
    // REGISTER NEW PATIENT (Creates User + Patient)
    // =====================================================
    @PostMapping("/register")
    public ResponseEntity<?> registerPatient(@Valid @RequestBody Patient patient) {

        try {
            Patient savedPatient = patientService.registerPatient(patient);
            return ResponseEntity.ok(savedPatient);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    // =====================================================
    // GET PATIENT BY ID (Doctor or Admin only)
    // =====================================================
    @PreAuthorize("hasAnyRole('DOCTOR','ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable Long id) {

        Optional<Patient> patient = patientService.getPatientById(id);

        if (patient.isPresent()) {
            return ResponseEntity.ok(patient.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // =====================================================
    // GET CURRENT LOGGED-IN PATIENT PROFILE
    // =====================================================
    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/me")
    public ResponseEntity<?> getMyProfile() {

        Optional<Patient> patient = patientService.getCurrentLoggedInPatient();

        if (patient.isPresent()) {
            return ResponseEntity.ok(patient.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // =====================================================
    // UPDATE CURRENT LOGGED-IN PATIENT PROFILE
    // =====================================================
    @PreAuthorize("hasRole('PATIENT')")
    @PutMapping("/me")
    public ResponseEntity<?> updateMyProfile(@RequestBody Patient updatedPatient) {

        Optional<Patient> updated =
                patientService.updateCurrentPatientProfile(updatedPatient);

        if (updated.isPresent()) {
            return ResponseEntity.ok(updated.get());
        } else {
            return ResponseEntity.badRequest().body("Unable to update profile");
        }
    }
}
