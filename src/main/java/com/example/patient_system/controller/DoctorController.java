package com.example.patient_system.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.patient_system.model.Appointment;
import com.example.patient_system.model.Doctor;
import com.example.patient_system.model.Medication;
import com.example.patient_system.model.Patient;
import com.example.patient_system.service.AppointmentService;
import com.example.patient_system.service.DoctorService;
import com.example.patient_system.service.MedicationService;
import com.example.patient_system.service.PatientService;

@Controller
@RequestMapping("/doctor")
@PreAuthorize("hasRole('DOCTOR')")
public class DoctorController {

    private final DoctorService doctorService;
    private final AppointmentService appointmentService;
    private final MedicationService medicationService;
    private final PatientService patientService;

    public DoctorController(DoctorService doctorService,
                            AppointmentService appointmentService,
                            MedicationService medicationService,
                            PatientService patientService) {
        this.doctorService = doctorService;
        this.appointmentService = appointmentService;
        this.medicationService = medicationService;
        this.patientService = patientService;
    }

    // =====================================
    // DOCTOR DASHBOARD
    // =====================================
    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        Doctor doctor = doctorService.getCurrentLoggedInDoctor()
                .orElseThrow();

        List<Appointment> pendingAppointments =
                appointmentService.getPendingAppointmentsForDoctor(doctor);

        List<Appointment> allAppointments =
                appointmentService.getAppointmentsByDoctor(doctor);

        model.addAttribute("doctor", doctor);
        model.addAttribute("pendingAppointments", pendingAppointments);
        model.addAttribute("appointments", allAppointments);

        return "doctor-dashboard";
    }

    // =====================================
    // APPROVE APPOINTMENT
    // =====================================
    @PostMapping("/appointments/{id}/approve")
    public String approveAppointment(@PathVariable Long id) {

        appointmentService.approveAppointment(id);

        return "redirect:/doctor/dashboard";
    }

    // =====================================
    // REJECT APPOINTMENT
    // =====================================
    @PostMapping("/appointments/{id}/reject")
    public String rejectAppointment(@PathVariable Long id) {

        appointmentService.rejectAppointment(id);

        return "redirect:/doctor/dashboard";
    }

    // =====================================
    // COMPLETE APPOINTMENT
    // =====================================
    @PostMapping("/appointments/{id}/complete")
    public String completeAppointment(@PathVariable Long id) {

        appointmentService.completeAppointment(id);

        return "redirect:/doctor/dashboard";
    }

    // =====================================
    // VIEW PATIENT DETAILS
    // =====================================
    @GetMapping("/patient/{id}")
    public String viewPatient(@PathVariable Long id, Model model) {

        Patient patient = patientService.getPatientById(id)
                .orElseThrow();

        List<Medication> medications =
                medicationService.getMedicationsByPatient(id);

        model.addAttribute("patient", patient);
        model.addAttribute("medications", medications);

        return "doctor-patient-view";
    }

    // =====================================
    // PRESCRIBE MEDICATION
    // =====================================
    @PostMapping("/prescribe")
    public String prescribeMedication(@RequestParam Long patientId,
                                      @ModelAttribute Medication medication) {

        Doctor doctor = doctorService.getCurrentLoggedInDoctor()
                .orElseThrow();

        Patient patient = patientService.getPatientById(patientId)
                .orElseThrow();

        medicationService.prescribeMedication(doctor, patient, medication);

        return "redirect:/doctor/patient/" + patientId;
    }
}
