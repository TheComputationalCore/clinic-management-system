package com.example.patient_system.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.patient_system.model.User;
import com.example.patient_system.repository.UserRepository;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 🔐 Password Encoder (BCrypt)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 🔐 Load User by EMAIL for authentication
    @Bean
    public org.springframework.security.core.userdetails.UserDetailsService userDetailsService() {
        return email -> {

            User user = userRepository.findByEmail(email)
                    .orElseThrow(() ->
                            new UsernameNotFoundException("User not found: " + email)
                    );

            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles(user.getRole().replace("ROLE_", "")) // ADMIN, DOCTOR, PATIENT
                    .build();
        };
    }

    // 🔐 Security Configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http

            // ✅ CSRF ENABLED (default)
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**") // only if using H2
            )

            // 🔐 Authorization Rules
            .authorizeHttpRequests(auth -> auth

                // Public Routes
                .requestMatchers("/", "/login", "/register",
                        "/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()

                // Admin Routes
                .requestMatchers("/admin/**").hasRole("ADMIN")

                // Doctor Routes
                .requestMatchers("/doctor/**").hasRole("DOCTOR")

                // Patient Routes
                .requestMatchers("/appointments/**",
                                 "/medications/**",
                                 "/profile/**").hasRole("PATIENT")

                // Everything else requires authentication
                .anyRequest().authenticated()
            )

            // 🔐 Custom Login
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")

                // Role-based redirect after login
                .successHandler((request, response, authentication) -> {

                    var authorities = authentication.getAuthorities();

                    if (authorities.stream()
                            .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {

                        response.sendRedirect("/admin/dashboard");

                    } else if (authorities.stream()
                            .anyMatch(a -> a.getAuthority().equals("ROLE_DOCTOR"))) {

                        response.sendRedirect("/doctor/dashboard");

                    } else {

                        response.sendRedirect("/"); // Patient
                    }
                })

                .failureUrl("/login?error")
                .permitAll()
            )

            // 🔐 Logout
            .logout(logout -> logout
                .logoutUrl("/logout")                // POST only
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            )

            // Optional (ONLY for H2 console)
            .headers(headers -> headers
                .frameOptions(frame -> frame.disable())
            );

        return http.build();
    }
}
