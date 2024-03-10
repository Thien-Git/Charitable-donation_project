package com.thiennh.springcrud.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DonationDTO {
	// dung de lay danh sach + getById 
	private Integer id;
	private String code;
	
	// Lấy thời gian hiện tại
	LocalDateTime localDateTime = LocalDateTime.now();
		
	// Định dạng đối tượng LocalDateTime thành String
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private String created = localDateTime.format(formatter);
	
	private String description;
	private String endDate;
	private Integer money;
	private String name;
	private String organizationName;
	private String phoneNumber;
	private String startDate;
	private Integer status;
	
	
	public DonationDTO() {
	}
	public DonationDTO(Integer id, String code, String created, String description, String endDate, Integer money, String name,
			String organizationName, String phoneNumber, String startDate, Integer status) {
		this.id = id;
		this.code = code;
		this.created = created;
		this.description = description;
		this.endDate = endDate;
		this.money = money;
		this.name = name;
		this.organizationName = organizationName;
		this.phoneNumber = phoneNumber;
		this.startDate = startDate;
		this.status = status;
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
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
