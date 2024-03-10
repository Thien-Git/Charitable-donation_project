package com.thiennh.springcrud.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DonationAddDTO {

	private Integer id;
	private String code;
	private String name;
	private String startDate;
	private String endDate;
	private String organizationName;
	private String phoneNumber;
	private String description;
	
	
	// Lấy thời gian hiện tại
	LocalDateTime localDateTime = LocalDateTime.now();
		
	// Định dạng đối tượng LocalDateTime thành String
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	private String created = localDateTime.format(formatter);

	public DonationAddDTO() {
	}

	

	public DonationAddDTO(Integer id, String code, String name, String startDate, String endDate,
			String organizationName, String phoneNumber, String description, LocalDateTime localDateTime,
			DateTimeFormatter formatter, String created) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.organizationName = organizationName;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.localDateTime = localDateTime;
		this.formatter = formatter;
		this.created = created;
	}



	public String getCreated() {
		return created;
	}



	public void setCreated(String created) {
		this.created = created;
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

}
