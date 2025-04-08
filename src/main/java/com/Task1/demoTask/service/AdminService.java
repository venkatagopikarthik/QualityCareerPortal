package com.Task1.demoTask.service;

import com.Task1.demoTask.model.Admin;
import com.Task1.demoTask.repository.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        // No need to create admin here as it's handled by AdminInitializer
    }

    public Optional<Admin> findByAdminId(String adminId) {
        return adminRepository.findByAdminId(adminId);
    }

    public Admin createAdmin(Admin admin) {
        if (adminRepository.existsByAdminId(admin.getAdminId())) {
            throw new RuntimeException("Admin ID already exists");
        }
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    public boolean validateAdmin(String adminId, String password) {
        Optional<Admin> admin = adminRepository.findByAdminId(adminId);
        return admin.isPresent() && passwordEncoder.matches(password, admin.get().getPassword());
    }
}