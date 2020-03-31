package com.imcs.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES_TEST")
public class EmployeeDTO implements Serializable {
	
	@Id
	@Column(name = "EMPLOYEE_ID")
	private String empId;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "EMAIL")
	private String emailId;

	public EmployeeDTO() {

	}

	public EmployeeDTO(String empId, String lastName, String firstName, String emailId) {
		this.empId = empId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.emailId = emailId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", lastName=" + lastName + ", firstName=" + firstName + ", emailId="
				+ emailId + "]";
	}
	
	
}
