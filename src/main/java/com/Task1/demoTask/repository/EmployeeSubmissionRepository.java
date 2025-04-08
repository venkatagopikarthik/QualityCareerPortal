package com.Task1.demoTask.repository;

import com.Task1.demoTask.model.EmployeeSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeSubmissionRepository extends JpaRepository<EmployeeSubmission, Long> {}
