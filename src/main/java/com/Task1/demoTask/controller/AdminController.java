package com.Task1.demoTask.controller;

import com.Task1.demoTask.model.Admin;
import com.Task1.demoTask.model.Employee;
import com.Task1.demoTask.model.EmployeeDetails;
import com.Task1.demoTask.model.EmployeeSubmission;
import com.Task1.demoTask.repository.AdminRepository;
import com.Task1.demoTask.repository.EmployeeDetailsRepository;
import com.Task1.demoTask.repository.EmployeeSubmissionRepository;
import com.Task1.demoTask.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final EmployeeService employeeService;
    private final AdminRepository adminRepository;
    @Autowired
    EmployeeDetailsRepository employeeDetailsRepository;
    @Autowired
    EmployeeSubmissionRepository submissionRepository;

    @Autowired
    public AdminController(EmployeeService employeeService, AdminRepository adminRepository) {
        this.employeeService = employeeService;
        this.adminRepository = adminRepository;
    }
    @GetMapping("/submitted-forms")
    public String showSubmittedForms(Model model) {
        List<EmployeeDetails> forms = employeeDetailsRepository.findAll();
        model.addAttribute("forms", forms);
        return "employee/submitted_forms";
    }

    @GetMapping("/addemployee")
    @PreAuthorize("hasRole('ADMIN')")
    public String showAddEmployeePage(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        List<EmployeeDetails> details = employeeDetailsRepository.findAll(); // Inject repository

        System.out.println(details);
        System.out.println("hi");
        System.out.println("employees");
        System.out.println(employees);
        model.addAttribute("employees", employees);
        model.addAttribute("submissions", details);
        return "admin/addemployee";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "admin/login";
    }

//    @GetMapping("/addemployee")
//    @PreAuthorize("hasRole('ADMIN')")
//    public String showAddEmployeePage(Model model) {
//        List<Employee> employees = employeeService.getAllEmployees();
//        model.addAttribute("employees", employees);
//        return "admin/addemployee";
//    }

    @PostMapping("/employee/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/admin/addemployee";
    }

    @GetMapping("/employee/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditEmployeePage(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "admin/editEmployee";
    }

    @PostMapping("/employee/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return "redirect:/admin/addemployee";
    }

    @GetMapping("/employee/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/admin/addemployee";
    }

    @GetMapping("/check-admin")
    public String checkAdminData(Model model) {
        List<Admin> admins = adminRepository.findAll();
        model.addAttribute("admins", admins);
        return "admin/check";
    }
}