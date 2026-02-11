package com.example.patient_system.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.patient_system.model.Appointment;
import com.example.patient_system.model.AppointmentStatus;
import com.example.patient_system.model.Doctor;
import com.example.patient_system.model.Medication;
import com.example.patient_system.model.Patient;
import com.example.patient_system.model.User;
import com.example.patient_system.service.AppointmentService;
import com.example.patient_system.service.DoctorService;
import com.example.patient_system.service.MedicationService;
import com.example.patient_system.service.PatientService;

@Controller
public class WebController {

    private final PatientService patientService;
    private final DoctorService doctorService;
    private final AppointmentService appointmentService;
    private final MedicationService medicationService;

    public WebController(PatientService patientService,
                         DoctorService doctorService,
                         AppointmentService appointmentService,
                         MedicationService medicationService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.appointmentService = appointmentService;
        this.medicationService = medicationService;
    }

    // ======================
    // HOME (PATIENT DASHBOARD)
    // ======================
    @GetMapping("/")
    public String home(Model model, Authentication authentication) {

        if (authentication == null || !authentication.isAuthenticated()) {
            return "index"; // Public landing page
        }

        String email = authentication.getName();

        Optional<Patient> optionalPatient = patientService.findByEmail(email);

        if (optionalPatient.isEmpty()) {
            // If logged-in user is admin/doctor
            return "index";
        }

        Patient patient = optionalPatient.get();

        List<Appointment> appointments =
                appointmentService.getAppointmentsByPatient(patient);

        List<Medication> medications =
                medicationService.getMedicationsByPatient(patient.getId());

        model.addAttribute("patientName", patient.getName());
        model.addAttribute("appointments", appointments);
        model.addAttribute("appointmentCount", appointments.size());
        model.addAttribute("medications", medications);
        model.addAttribute("medicationCount", medications.size());

        return "index";
    }

    // ======================
    // REGISTER
    // ======================
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

        Patient patient = new Patient();
        patient.setUser(new User()); // Required for nested binding

        model.addAttribute("patient", patient);
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute Patient patient) {

        patientService.registerPatient(patient);

        return "redirect:/login";
    }

    // ======================
    // LOGIN
    // ======================
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // ======================
    // APPOINTMENTS
    // ======================
    @GetMapping("/appointments")
    public String showAppointments(Model model, Authentication authentication) {

        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        String email = authentication.getName();

        Patient patient = patientService.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));

        List<Doctor> doctors = doctorService.getAllDoctors();
        List<Appointment> appointments =
                appointmentService.getAppointmentsByPatient(patient);

        model.addAttribute("doctors", doctors);
        model.addAttribute("appointments", appointments);

        return "appointments";
    }

    @PostMapping("/appointments/book")
    public String bookAppointment(@RequestParam Long doctorId,
                                  @RequestParam String appointmentTime,
                                  @RequestParam(required = false) String notes,
                                  Authentication authentication) {

        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        String email = authentication.getName();

        Patient patient = patientService.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));

        Doctor doctor = doctorService.getDoctorById(doctorId);

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentTime(
                LocalDateTime.parse(appointmentTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        );
        appointment.setStatus(AppointmentStatus.PENDING);
        appointment.setNotes(notes);

        appointmentService.bookAppointment(appointment);

        return "redirect:/appointments";
    }

    // ======================
    // MEDICATIONS
    // ======================
    @GetMapping("/medications")
    public String showMedications(Model model, Authentication authentication) {

        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        String email = authentication.getName();

        Patient patient = patientService.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));

        List<Medication> medications =
                medicationService.getMedicationsByPatient(patient.getId());

        model.addAttribute("medications", medications);

        return "medications";
    }

}
