package com.Task1.demoTask.config;

import com.Task1.demoTask.model.Admin;
import com.Task1.demoTask.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AdminInitializer implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminInitializer(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Delete any existing admin with the same ID
        adminRepository.deleteByAdminId("Tharun@123");
        
        // Create new admin
        Admin admin = new Admin();
        admin.setAdminId("Tharun@123");
        admin.setPassword(passwordEncoder.encode("Mahi@123"));
        admin.setRole("ROLE_ADMIN");
        
        adminRepository.save(admin);
        System.out.println("Admin created with ID: Tharun@123 and password: Mahi@123");
    }
} 