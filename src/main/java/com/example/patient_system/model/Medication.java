package com.example.patient_system.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔗 Patient receiving the prescription
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    // 🔗 Doctor who prescribed it
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor prescribedBy;

    @Column(nullable = false)
    private String name;

    private String dosage;

    private String frequency;

    private LocalDate prescribedDate;

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getPrescribedBy() {
        return prescribedBy;
    }

    public void setPrescribedBy(Doctor prescribedBy) {
        this.prescribedBy = prescribedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public LocalDate getPrescribedDate() {
        return prescribedDate;
    }

    public void setPrescribedDate(LocalDate prescribedDate) {
        this.prescribedDate = prescribedDate;
    }
}
