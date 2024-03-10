package com.thiennh.springcrud.dto;

public class DonationUpdateDTO {
//	Lay 1 so truong ra de dua vao form
	private String code;
	private String name;
	private String startDate;
	private String endDate;
	private String organizationName;
	private String phoneNumber;
	private String description;
	
	
//	hidden
	private Integer id;
	private String created;
	private Integer money;
	private Integer status;
	
	public DonationUpdateDTO() {
	}
	public DonationUpdateDTO(String code, String name, String startDate, String endDate, String organizationName,
			String phoneNumber, String description, Integer id, String created, Integer money, Integer status) {
		this.code = code;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.organizationName = organizationName;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.id = id;
		this.created = created;
		this.money = money;
		this.status = status;
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
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
}
