package com.Task1.demoTask.repository;

import com.Task1.demoTask.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {
} 