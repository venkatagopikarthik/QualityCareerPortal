package com.Task1.demoTask.config;

import com.Task1.demoTask.model.Admin;
import com.Task1.demoTask.model.Employee;
import com.Task1.demoTask.repository.AdminRepository;
import com.Task1.demoTask.repository.EmployeeRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final EmployeeRepository employeeRepository;

    public CustomUserDetailsService(AdminRepository adminRepository, EmployeeRepository employeeRepository) {
        this.adminRepository = adminRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Try to find admin first
        Admin admin = adminRepository.findByAdminId(username)
                .orElse(null);

        if (admin != null) {
            return new User(
                admin.getAdminId(),
                admin.getPassword(),
                true, true, true, true,
                Collections.singletonList(new SimpleGrantedAuthority(admin.getRole()))
            );
        }

        // If not admin, try to find employee
        Employee employee = employeeRepository.findByEmployeeId(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new User(
            employee.getEmployeeId(),
            employee.getPassword(),
            true, true, true, true,
            Collections.singletonList(new SimpleGrantedAuthority(employee.getRole()))
        );
    }
}