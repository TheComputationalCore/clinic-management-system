package com.example.patient_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.patient_system.model.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

    // 🔹 Get all prescriptions for a patient
    List<Medication> findByPatientId(Long patientId);

    // 🔹 Get all prescriptions written by a doctor
    List<Medication> findByPrescribedById(Long doctorId);

    // 🔹 Get prescriptions for a specific patient written by a specific doctor
    List<Medication> findByPatientIdAndPrescribedById(Long patientId, Long doctorId);
}
