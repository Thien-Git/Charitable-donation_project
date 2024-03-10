package com.thiennh.springcrud.dto;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class UserDTO {

//	Dung cho list account + getById
	private Integer id;
	private String fullName;

	@Email(message = "Email should be valid")
	private String email;

	@Pattern(regexp = "^0[0-9]{9,10}$", message = "Invalid phone number")
	private String phoneNumber;
	private String userName;
	private String address;
	private RoleDTO role;
	private Integer status;
	
	// Lấy thời gian hiện tại
	LocalDateTime localDateTime = LocalDateTime.now();
		
	// Định dạng đối tượng LocalDateTime thành String
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private String createdAt = localDateTime.format(formatter);
		
//	private String createdAt; 
	private String note;
	private String password;

	public UserDTO() {
	}

	public UserDTO(Integer id, String fullName, String email,
			String phoneNumber, String userName,
			String address, RoleDTO role, Integer status, String createdAt, String note, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.address = address;
		this.role = role;
		this.status = status;
		this.createdAt = createdAt;
		this.note = note;
		this.password = password;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
