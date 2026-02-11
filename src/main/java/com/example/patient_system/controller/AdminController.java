package com.example.patient_system.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.patient_system.model.Doctor;
import com.example.patient_system.model.Patient;
import com.example.patient_system.model.User;
import com.example.patient_system.repository.DoctorRepository;
import com.example.patient_system.repository.PatientRepository;
import com.example.patient_system.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminController(DoctorRepository doctorRepository,
                           PatientRepository patientRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // =========================
    // DASHBOARD
    // =========================
    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("doctorCount", doctorRepository.count());
        model.addAttribute("patientCount", patientRepository.count());

        return "admin-dashboard";
    }

    // =========================
    // VIEW DOCTORS
    // =========================
    @GetMapping("/doctors")
    public String viewDoctors(Model model) {

        model.addAttribute("doctors", doctorRepository.findAll());

        return "admin-doctors";
    }

    // =========================
    // ADD DOCTOR (FORM)
    // =========================
    @GetMapping("/doctors/add")
    public String showAddDoctorForm(Model model) {

        Doctor doctor = new Doctor();
        doctor.setUser(new User()); // Required for nested binding

        model.addAttribute("doctor", doctor);

        return "admin-add-doctor";
    }

    // =========================
    // SAVE DOCTOR
    // =========================
    @PostMapping("/doctors/add")
    public String saveDoctor(@ModelAttribute Doctor doctor) {

        String email = doctor.getUser().getEmail().toLowerCase().trim();

        if (userRepository.existsByEmail(email)) {
            return "redirect:/admin/doctors?error=email_exists";
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(doctor.getUser().getPassword()));
        user.setRole("ROLE_DOCTOR");

        User savedUser = userRepository.save(user);

        doctor.setUser(savedUser);
        doctorRepository.save(doctor);

        return "redirect:/admin/doctors?success";
    }

    // =========================
    // DELETE DOCTOR
    // =========================
    @PostMapping("/doctors/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        User user = doctor.getUser();

        // ✅ Delete doctor first (child)
        doctorRepository.delete(doctor);

        // ✅ Then delete linked user (parent)
        userRepository.delete(user);

        return "redirect:/admin/doctors?deleted";
    }

    // =========================
    // VIEW PATIENTS
    // =========================
    @GetMapping("/patients")
    public String viewPatients(Model model) {

        model.addAttribute("patients", patientRepository.findAll());

        return "admin-patients";
    }

    // =========================
    // DELETE PATIENT
    // =========================
    @PostMapping("/patients/delete/{id}")
    public String deletePatient(@PathVariable Long id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));

        User user = patient.getUser();

        // ✅ Delete patient first (child)
        patientRepository.delete(patient);

        // ✅ Then delete linked user
        userRepository.delete(user);

        return "redirect:/admin/patients?deleted";
    }

    // =========================
    // SETTINGS
    // =========================
    @GetMapping("/settings")
    public String settings() {
        return "admin-settings";
    }
}
