package com.thiennh.springcrud.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "email")
	private String email;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "address")
	private String address;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	private RoleEntity role;
	
	@Column(name = "status")
	private Integer status;
	@Column(name = "note")
	private String note;
	@Column(name = "password")
	private String password;
	@Column(name = "created")
	private String createdAt;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<UserDonationEntity> userDonations;
	
//	-----------------------------------------

	public UserEntity() {
	}

	public UserEntity(String address, String email, String fullName, String note, String password, String phoneNumber,
			Integer status, String userName, String createdAt, RoleEntity role) {
		this.address = address;
		this.email = email;
		this.fullName = fullName;
		this.note = note;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.userName = userName;
		this.createdAt = createdAt;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public List<UserDonationEntity> getUserDonations() {
		return userDonations;
	}

	public void setUserDonations(List<UserDonationEntity> userDonations) {
		this.userDonations = userDonations;
	}
	
	public void addUserDonation(UserDonationEntity userDonation) {
		if (userDonations == null) {
			userDonations = new ArrayList<UserDonationEntity>();
		}
		userDonations.add(userDonation);
	}

	

	

}
