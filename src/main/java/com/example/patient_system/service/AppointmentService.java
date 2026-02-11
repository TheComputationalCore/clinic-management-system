package com.example.patient_system.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.patient_system.model.Appointment;
import com.example.patient_system.model.AppointmentStatus;
import com.example.patient_system.model.Doctor;
import com.example.patient_system.model.Patient;
import com.example.patient_system.repository.AppointmentRepository;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorService doctorService;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorService doctorService) {
        this.appointmentRepository = appointmentRepository;
        this.doctorService = doctorService;
    }

    // =====================================
    // PATIENT BOOKS APPOINTMENT
    // =====================================
    public Appointment bookAppointment(Appointment appointment) {

        Patient patient = appointment.getPatient();
        Doctor doctor = doctorService.getDoctorById(appointment.getDoctor().getId());
        LocalDateTime appointmentTime = appointment.getAppointmentTime();

        if (patient == null || doctor == null || appointmentTime == null) {
            throw new IllegalArgumentException(
                    "Patient, doctor, and appointment time must not be null"
            );
        }

        // Check for 30-minute conflict window
        List<Appointment> conflicts =
                appointmentRepository.findByDoctorIdAndAppointmentTimeBetween(
                        doctor.getId(),
                        appointmentTime.minusMinutes(30),
                        appointmentTime.plusMinutes(30)
                );

        if (!conflicts.isEmpty()) {
            throw new IllegalArgumentException("Appointment slot is not available");
        }

        appointment.setDoctor(doctor);
        appointment.setStatus(AppointmentStatus.PENDING);

        return appointmentRepository.save(appointment);
    }

    // =====================================
    // GET APPOINTMENTS FOR PATIENT
    // =====================================
    public List<Appointment> getAppointmentsByPatient(Patient patient) {

        if (patient == null) {
            return Collections.emptyList();
        }

        return appointmentRepository.findByPatientId(patient.getId());
    }

    // =====================================
    // GET APPOINTMENTS FOR DOCTOR
    // =====================================
    public List<Appointment> getAppointmentsByDoctor(Doctor doctor) {

        if (doctor == null) {
            return Collections.emptyList();
        }

        return appointmentRepository.findByDoctorId(doctor.getId());
    }

    // =====================================
    // GET PENDING APPOINTMENTS FOR DOCTOR
    // =====================================
    public List<Appointment> getPendingAppointmentsForDoctor(Doctor doctor) {

        if (doctor == null) {
            return Collections.emptyList();
        }

        return appointmentRepository.findByDoctorIdAndStatus(
                doctor.getId(),
                AppointmentStatus.PENDING
        );
    }

    // =====================================
    // DOCTOR APPROVES APPOINTMENT
    // =====================================
    public Appointment approveAppointment(Long appointmentId) {

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));

        appointment.setStatus(AppointmentStatus.APPROVED);

        return appointmentRepository.save(appointment);
    }

    // =====================================
    // DOCTOR REJECTS APPOINTMENT
    // =====================================
    public Appointment rejectAppointment(Long appointmentId) {

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));

        appointment.setStatus(AppointmentStatus.REJECTED);

        return appointmentRepository.save(appointment);
    }

    // =====================================
    // MARK APPOINTMENT COMPLETED
    // =====================================
    public Appointment completeAppointment(Long appointmentId) {

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));

        appointment.setStatus(AppointmentStatus.COMPLETED);

        return appointmentRepository.save(appointment);
    }
}
