package com.example.patient_system.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.patient_system.model.Doctor;
import com.example.patient_system.model.Medication;
import com.example.patient_system.model.Patient;
import com.example.patient_system.repository.MedicationRepository;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;

    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    // =====================================
    // DOCTOR PRESCRIBES MEDICATION
    // =====================================
    public Medication prescribeMedication(Doctor doctor,
                                          Patient patient,
                                          Medication medication) {

        medication.setPrescribedBy(doctor);
        medication.setPatient(patient);
        medication.setPrescribedDate(LocalDate.now());

        return medicationRepository.save(medication);
    }

    // =====================================
    // GET ALL PRESCRIPTIONS FOR PATIENT
    // =====================================
    public List<Medication> getMedicationsByPatient(Long patientId) {
        return medicationRepository.findByPatientId(patientId);
    }

    // =====================================
    // GET ALL PRESCRIPTIONS WRITTEN BY DOCTOR
    // =====================================
    public List<Medication> getMedicationsByDoctor(Long doctorId) {
        return medicationRepository.findByPrescribedById(doctorId);
    }

    // =====================================
    // DELETE PRESCRIPTION (Doctor/Admin Only)
    // =====================================
    public void deleteMedication(Long medicationId) {
        medicationRepository.deleteById(medicationId);
    }
}
