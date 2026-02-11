package com.example.patient_system.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.patient_system.model.Patient;
import com.example.patient_system.model.User;
import com.example.patient_system.repository.PatientRepository;
import com.example.patient_system.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private PatientService patientService;

    // ============================================
    // ✅ TEST: Successful Registration
    // ============================================
    @Test
    void testRegisterPatientSuccess() {

        // Arrange
        User user = new User();
        user.setEmail("john@example.com");
        user.setPassword("password");

        Patient patient = new Patient();
        patient.setName("John Doe");
        patient.setPhone("9999999999");
        patient.setMedicalHistory("No issues");
        patient.setUser(user);

        when(userRepository.existsByEmail("john@example.com"))
                .thenReturn(false);

        when(passwordEncoder.encode("password"))
                .thenReturn("encodedPassword");

        when(userRepository.save(any(User.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        when(patientRepository.save(any(Patient.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Patient savedPatient = patientService.registerPatient(patient);

        // Assert
        assertEquals("John Doe", savedPatient.getName());
        assertEquals("john@example.com", savedPatient.getUser().getEmail());
        assertEquals("encodedPassword", savedPatient.getUser().getPassword());
        assertEquals("ROLE_PATIENT", savedPatient.getUser().getRole());

        verify(userRepository, times(1)).save(any(User.class));
        verify(patientRepository, times(1)).save(any(Patient.class));
    }

    // ============================================
    // ✅ TEST: Email Already Exists
    // ============================================
    @Test
    void testRegisterPatientEmailExists() {

        // Arrange
        User user = new User();
        user.setEmail("john@example.com");
        user.setPassword("password");

        Patient patient = new Patient();
        patient.setUser(user);

        when(userRepository.existsByEmail("john@example.com"))
                .thenReturn(true);

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> patientService.registerPatient(patient));

        verify(userRepository, never()).save(any());
        verify(patientRepository, never()).save(any());
    }

    // ============================================
    // ✅ TEST: Invalid Patient Data
    // ============================================
    @Test
    void testRegisterPatientInvalidData() {

        Patient patient = new Patient(); // No user attached

        assertThrows(IllegalArgumentException.class,
                () -> patientService.registerPatient(patient));

        verify(userRepository, never()).save(any());
        verify(patientRepository, never()).save(any());
    }
}
