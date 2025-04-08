package com.Task1.demoTask.controller;

import com.Task1.demoTask.model.Employee;
import com.Task1.demoTask.model.EmployeeDetails;
import com.Task1.demoTask.repository.EmployeeDetailsRepository;
import com.Task1.demoTask.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "employee/login";
    }

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public String showDashboard(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee/dashboard";
    }

    @GetMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/employee/dashboard";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return "redirect:/employee/dashboard";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee/dashboard";
    }

    
    @GetMapping("/form")
    public String showForm(HttpSession session, Model model, Authentication authentication) {
        if (authentication != null) {
            // Fetch employee ID from logged-in user (assumes username is employeeId)
            String employeeId = authentication.getName();
            session.setAttribute("employeeId", employeeId);
            model.addAttribute("employeeId", employeeId);
        }
        return "employee/form";
    }

    
    @PostMapping("/submit")
    @ResponseBody
    public ResponseEntity<String> submitForm(@RequestBody Map<String, String> formData) {
        try {
            EmployeeDetails details = new EmployeeDetails();
            details.setEmployeeId(formData.get("employeeId"));
            details.setSubmissionDate(LocalDateTime.now());

            details.setCustomerName(formData.get("customerName"));
            details.setMobileNumber(formData.get("mobileNumber"));
            details.setAlternateMobile(formData.get("alternateMobile"));
            details.setEmployment(formData.get("employment"));
            details.setLanguage(formData.get("language"));
            details.setHasCreditCard(formData.get("hasCreditCard"));
            details.setSubmissionDate(LocalDateTime.now());

            employeeDetailsRepository.save(details);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving form data: " + e.getMessage());
        }
    }

    @GetMapping("/check-employees")
    public String checkEmployeeData(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee/check";
    }
}
