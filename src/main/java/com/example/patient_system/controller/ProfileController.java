package com.example.patient_system.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.patient_system.model.Patient;
import com.example.patient_system.service.PatientService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final PatientService patientService;

    public ProfileController(PatientService patientService) {
        this.patientService = patientService;
    }

    // ===============================
    // VIEW PROFILE
    // ===============================
    @GetMapping
    public String viewProfile(Model model) {

        Optional<Patient> patient =
                patientService.getCurrentLoggedInPatient();

        patient.ifPresent(p -> model.addAttribute("patient", p));

        return "profile";
    }

    // ===============================
    // EDIT PROFILE PAGE
    // ===============================
    @GetMapping("/edit")
    public String editProfile(Model model) {

        Optional<Patient> patient =
                patientService.getCurrentLoggedInPatient();

        patient.ifPresent(p -> model.addAttribute("patient", p));

        return "edit-profile";
    }

    // ===============================
    // UPDATE PROFILE
    // ===============================
    @PostMapping("/update")
    public String updateProfile(@ModelAttribute Patient updatedPatient) {

        patientService.updateCurrentPatientProfile(updatedPatient);

        return "redirect:/profile";
    }
}
