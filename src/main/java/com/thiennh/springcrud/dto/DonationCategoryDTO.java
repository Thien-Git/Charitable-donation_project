package com.thiennh.springcrud.dto;

public class DonationCategoryDTO {

	private String name;
	private String startDate;
	private String endDate;
	private String organizationName;
	private String phoneNumber;
	private Integer status;
	private Integer money;

	private Integer id;
	private String code;
	private String created;
	private String description;

	public DonationCategoryDTO() {
	}

	public DonationCategoryDTO(String name, String startDate, String endDate, String organizationName,
			String phoneNumber, Integer status, Integer money, Integer id, String code, String created,
			String description) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.organizationName = organizationName;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.money = money;
		this.id = id;
		this.code = code;
		this.created = created;
		this.description = description;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
