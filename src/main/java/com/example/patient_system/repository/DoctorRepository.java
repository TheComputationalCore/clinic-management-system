package com.example.patient_system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.patient_system.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    // ============================================
    // FIND DOCTOR BY USER ID
    // ============================================
    Optional<Doctor> findByUserId(Long userId);

    // ============================================
    // FIND DOCTOR BY USER EMAIL (Ignore Case)
    // ============================================
    Optional<Doctor> findByUserEmailIgnoreCase(String email);

    // ============================================
    // FIND DOCTOR BY USER EMAIL (Fetch User)
    // Prevents LazyInitializationException
    // ============================================
    @Query("SELECT d FROM Doctor d JOIN FETCH d.user u WHERE LOWER(u.email) = LOWER(:email)")
    Optional<Doctor> findByUserEmail(@Param("email") String email);

    // ============================================
    // FIND DOCTORS BY SPECIALIZATION (Ignore Case)
    // ============================================
    List<Doctor> findBySpecializationIgnoreCase(String specialization);

    // ============================================
    // COUNT DOCTORS BY SPECIALIZATION
    // ============================================
    long countBySpecializationIgnoreCase(String specialization);
}
