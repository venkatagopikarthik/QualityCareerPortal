package com.Task1.demoTask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_details")
public class EmployeeDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String timestamp;

    @Column(nullable = false)
    private String customerName;
    
    @Column(nullable = false)
    private String mobileNumber;
    
    private String alternateMobile;
    
    @Column(nullable = false)
    private String employment;
    
    @Column(nullable = false)
    private String language;
    
    @Column(nullable = false)
    private String hasCreditCard;
    
    @Column(nullable = false)
    private LocalDateTime submissionDate;
    private String employeeId;
    

    

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	// Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAlternateMobile() {
        return alternateMobile;
    }

    public void setAlternateMobile(String alternateMobile) {
        this.alternateMobile = alternateMobile;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHasCreditCard() {
        return hasCreditCard;
    }

    public void setHasCreditCard(String hasCreditCard) {
        this.hasCreditCard = hasCreditCard;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }
} 