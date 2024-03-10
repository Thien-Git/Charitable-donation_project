package com.thiennh.springcrud.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDonationQuickDTO {
	private String name;
	private Integer money;
	private Integer idUser;
	private Integer idDonation;
	private String text;
	
	// Lấy thời gian hiện tại
	LocalDateTime localDateTime = LocalDateTime.now();
	
	// Định dạng đối tượng LocalDateTime thành String
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	private String created = localDateTime.format(formatter);
	
	private Integer status; //mặc định = 0 (do chưa được admin xác nhận)

	public UserDonationQuickDTO() {
	}

	public UserDonationQuickDTO(String name, Integer money, Integer idUser, Integer idDonation, String text,
			String created, Integer status) {
		this.name = name;
		this.money = money;
		this.idUser = idUser;
		this.idDonation = idDonation;
		this.text = text;
		this.created = created;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdDonation() {
		return idDonation;
	}

	public void setIdDonation(Integer idDonation) {
		this.idDonation = idDonation;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	

}
