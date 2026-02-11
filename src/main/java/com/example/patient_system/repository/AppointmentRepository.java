package com.example.patient_system.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.patient_system.model.Appointment;
import com.example.patient_system.model.AppointmentStatus;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // 🔹 Get all appointments for a patient
    List<Appointment> findByPatientId(Long patientId);

    // 🔹 Get all appointments for a doctor
    List<Appointment> findByDoctorId(Long doctorId);

    // 🔹 Get appointments for a doctor within a time range
    List<Appointment> findByDoctorIdAndAppointmentTimeBetween(
            Long doctorId,
            LocalDateTime startTime,
            LocalDateTime endTime
    );

    // 🔹 Get appointments by status
    List<Appointment> findByStatus(AppointmentStatus status);

    // 🔹 Get appointments for a doctor by status
    List<Appointment> findByDoctorIdAndStatus(Long doctorId, AppointmentStatus status);

    // 🔹 Get appointments for a patient by status
    List<Appointment> findByPatientIdAndStatus(Long patientId, AppointmentStatus status);
}
