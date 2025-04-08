package com.Task1.demoTask.controller;

import com.Task1.demoTask.model.EmployeeDetails;
import com.Task1.demoTask.model.EmployeeSubmission;
import com.Task1.demoTask.repository.EmployeeDetailsRepository;
import com.Task1.demoTask.repository.EmployeeSubmissionRepository;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeFormController {

    @Autowired
    private EmployeeSubmissionRepository submissionRepository;
  @Autowired
  EmployeeDetailsRepository employeeDetailsRepository;
    // Changed endpoint to avoid conflict
//  @PostMapping("/formsubmit")
//  public void submitForm(@RequestBody EmployeeSubmission submission) {
//      System.out.println("Form submitted: " + submission);
//      submissionRepository.save(submission);
//  }
  @PostMapping("/formsubmit")
  @ResponseBody
  public ResponseEntity<String> submitForm(@RequestBody EmployeeSubmission submission) {
      try {
          submissionRepository.save(submission);
          return ResponseEntity.ok("Saved successfully");
      } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed: " + e.getMessage());
      }
  }


//    @PostMapping("/submit")
//    @ResponseBody
//    public ResponseEntity<String> submitForm(@RequestBody Map<String, String> formData) {
//        try {
//            EmployeeDetails details = new EmployeeDetails();
//            details.setCustomerName(formData.get("customerName"));
//            details.setMobileNumber(formData.get("mobileNumber"));
//            details.setAlternateMobile(formData.get("alternateMobile"));
//            details.setEmployment(formData.get("employment"));
//            details.setLanguage(formData.get("language"));
//            details.setHasCreditCard(formData.get("hasCreditCard"));
//            details.setSubmissionDate(LocalDateTime.now());
//
//            employeeDetailsRepository.save(details);
//
//            return ResponseEntity.ok("Data saved successfully.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error saving form data: " + e.getMessage());
//        }
//    }

}
