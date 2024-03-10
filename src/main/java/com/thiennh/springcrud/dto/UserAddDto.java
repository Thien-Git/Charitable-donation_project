package com.thiennh.springcrud.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class UserAddDto {

	private Integer id;
	private String fullName;

//	(Valid thêm jar file của hibernate-validator-6.2.5.Final-dist)
	@Email(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Email should be valid")
	private String email;

	@Pattern(regexp = "^0[0-9]{9,10}$", message = "Invalid phone number")
	private String phoneNumber;

	private String address;
	private String userName;
	private String password;
//	private Role role;
	private Integer roleId;

	// Lấy thời gian hiện tại
	LocalDateTime localDateTime = LocalDateTime.now();

	// Định dạng đối tượng LocalDateTime thành String
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private String createdAt = localDateTime.format(formatter);

	public UserAddDto() {
	}

	public UserAddDto(Integer id, String fullName, String email, String phoneNumber, String address, String userName,
			String password, Integer roleId, LocalDateTime localDateTime, DateTimeFormatter formatter,
			String createdAt) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
		this.localDateTime = localDateTime;
		this.formatter = formatter;
		this.createdAt = createdAt;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}

}
