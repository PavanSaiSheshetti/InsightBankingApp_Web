package com.revature.ibaw.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO class
@Entity
@Table(name="ibaw.employees")
public class Employee {

	@Column
	private long employeeId;
	@Column
	private String employeeFirstName;
	@Column
	private String employeeLastName;
	@Column
	@Id
	private String employeeUserName;
	@Column
	private String employeePassword;
	
	//Default Constructor
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	//parameterized constructor
	public Employee(long employeeId, String employeeFirstName, String employeeLastName, String employeeUserName,
			String employeePassword) {
		super();
		this.employeeId = employeeId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeUserName = employeeUserName;
		this.employeePassword = employeePassword;
	}
	//Getter and Setter methods
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	public String getEmployeeUserName() {
		return employeeUserName;
	}
	public void setEmployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeFirstName=" + employeeFirstName + ", employeeLastName="
				+ employeeLastName + ", employeeUserName=" + employeeUserName + ", employeePassword=" + employeePassword
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(employeeFirstName, employeeId, employeeLastName, employeePassword, employeeUserName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(employeeFirstName, other.employeeFirstName) && employeeId == other.employeeId
				&& Objects.equals(employeeLastName, other.employeeLastName)
				&& Objects.equals(employeePassword, other.employeePassword)
				&& Objects.equals(employeeUserName, other.employeeUserName);
	}
	
}
