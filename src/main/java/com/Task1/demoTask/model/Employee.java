package com.Task1.demoTask.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
//import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "employees")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
//    @NotBlank(message = "Employee ID is required")
    private String employeeId;

    @Column(nullable = false)
//    @NotBlank(message = "Name is required")
    private String name;

    @Column(nullable = false)
//    @NotBlank(message = "Password is required")
    private String password;

    @Column(nullable = false)
//    @NotBlank(message = "Role is required")
    private String role = "ROLE_EMPLOYEE";

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}