package com.Task1.demoTask.repository;

import com.Task1.demoTask.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByAdminId(String adminId);
//    Optional<Admin> findByEmail(String email);
    boolean existsByAdminId(String adminId);
//    boolean existsByEmail(String email);
    
    @Transactional
    void deleteByAdminId(String adminId);
}