package com.thiennh.springcrud.dto;

public class UserLoginDTO {
	private Integer id;
	private String fullName;
	private String email;
	private String password;
	private Integer roleId;
	private Integer status;

	public UserLoginDTO() {
	}

	public UserLoginDTO(Integer id, String fullName, String email, String password, Integer roleId, Integer status) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.roleId = roleId;
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
