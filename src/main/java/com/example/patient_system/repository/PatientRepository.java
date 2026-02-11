package com.example.patient_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.patient_system.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    // =====================================================
    // Find patient by associated user's email
    // (Used for logged-in patient lookup)
    // =====================================================
    @Query("""
           SELECT p 
           FROM Patient p 
           JOIN FETCH p.user u 
           WHERE u.email = :email
           """)
    Optional<Patient> findByUserEmail(@Param("email") String email);


    // =====================================================
    // Optional: Fetch patient with user by patient ID
    // (Useful for admin/doctor views)
    // =====================================================
    @Query("""
           SELECT p 
           FROM Patient p 
           JOIN FETCH p.user
           WHERE p.id = :id
           """)
    Optional<Patient> findByIdWithUser(@Param("id") Long id);

}
