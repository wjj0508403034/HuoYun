package com.huoyun.core.employee.dto;

import com.huoyun.core.company.dto.DepartmentDTO;

public class EmployeeDTO {

	private long id;
	private Long code;
	private String firstName;
	private String lastName;
	private PositionDTO position;
	private String email;
	private String phone;
	private String fax;
	private String webSite;
	private EmployeeAddressDTO employeeAddress;
	private DepartmentDTO department;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public PositionDTO getPosition() {
		return position;
	}

	public void setPosition(PositionDTO position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public EmployeeAddressDTO getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(EmployeeAddressDTO employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getFullName() {
		return this.getFirstName() + this.getLastName();
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}
}
