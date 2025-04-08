package com.Task1.demoTask.service;

import com.Task1.demoTask.model.Employee;
import com.Task1.demoTask.repository.EmployeeRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public EmployeeService(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Employee createEmployee(Employee employee) {
        if (employeeRepository.existsByEmployeeId(employee.getEmployeeId())) {
            throw new RuntimeException("Employee ID already exists");
        }
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findByEmployeeId(String employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public boolean validateEmployee(String employeeId, String password) {
        Optional<Employee> employee = employeeRepository.findByEmployeeId(employeeId);
        return employee.isPresent() && passwordEncoder.matches(password, employee.get().getPassword());
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = findById(employee.getId());
        
        // Update fields
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmployeeId(employee.getEmployeeId());
        
        // Only update password if a new one is provided
        if (employee.getPassword() != null && !employee.getPassword().isEmpty()) {
            existingEmployee.setPassword(passwordEncoder.encode(employee.getPassword()));
        }
        
        // Check if new employeeId doesn't conflict with other employees
        if (!existingEmployee.getEmployeeId().equals(employee.getEmployeeId()) &&
            employeeRepository.existsByEmployeeId(employee.getEmployeeId())) {
            throw new RuntimeException("Employee ID already exists");
        }

        return employeeRepository.save(existingEmployee);
    }
}