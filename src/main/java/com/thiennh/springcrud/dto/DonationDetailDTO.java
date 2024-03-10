package com.thiennh.springcrud.dto;

import java.util.List;

import com.thiennh.springcrud.entity.UserDonationEntity;

public class DonationDetailDTO {

	private String code;
	private String name;
	private String startDate;
	private String endDate;
	
	private Integer totalMoney;
	
	private Integer status;
	private String organizationName;
	private String phoneNumber;
	private String description;

	private Integer id;
	private String created;

	private List<UserDonationEntity> userDonations;

//	private Integer money;
	public DonationDetailDTO() {
	}

	public DonationDetailDTO(String code, String name, String startDate, String endDate, Integer totalMoney,
			Integer status, String organizationName, String phoneNumber, String description, Integer id, String created,
			List<UserDonationEntity> userDonations) {
		this.code = code;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalMoney = totalMoney;
		this.status = status;
		this.organizationName = organizationName;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.id = id;
		this.created = created;
		this.userDonations = userDonations;
	}

	public List<UserDonationEntity> getUserDonations() {
		return userDonations;
	}

	public void setUserDonations(List<UserDonationEntity> userDonations) {
		this.userDonations = userDonations;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Integer totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
}
