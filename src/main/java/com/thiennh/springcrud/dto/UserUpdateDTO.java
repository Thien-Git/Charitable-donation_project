package com.thiennh.springcrud.dto;

// Dùng để cập nhật user
public class UserUpdateDTO {
	
	// dua vo form
	private String fullName;
	private String email;
	private String phoneNumber;
	private String address;
	private String userName;
	private Integer roleId;
	
	
//	hidden
	private Integer id;
	private Integer status;
	private String note;
	private String password;
	private String createdAt;
	
	
	public UserUpdateDTO() {
	}
	
	public UserUpdateDTO(Integer id, String fullName, String email, String phoneNumber, String address,
			String userName, Integer roleId, Integer status, String note, String password, String createdAt) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.userName = userName;
		this.roleId = roleId;
		this.status = status;
		this.note = note;
		this.password = password;
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
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	

}
