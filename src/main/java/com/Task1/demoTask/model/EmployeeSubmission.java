package com.Task1.demoTask.model;

import javax.persistence.*;

@Entity
@Table(name = "employee_submissions")
public class EmployeeSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String mobileNumber;
    private String alternateMobile;
    private String employment;
    private String language;
    private String hasCreditCard;
    private String employeeId;
    private String timestamp;

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

    // Getters and Setters
    
}
