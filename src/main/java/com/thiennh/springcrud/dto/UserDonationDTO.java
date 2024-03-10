package com.thiennh.springcrud.dto;

public class UserDonationDTO {
	private Integer id;
	private String created;
	private Integer money;
	private String name;
	private Integer status;
	private String text;
	private UserDTO user;
	private DonationDTO donation;

	public UserDonationDTO() {
	}

	

	public UserDonationDTO(String created, Integer money, String name, Integer status, String text,
			UserDTO user, DonationDTO donation) {
		this.created = created;
		this.money = money;
		this.name = name;
		this.status = status;
		this.text = text;
		this.user = user;
		this.donation = donation;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}



	public UserDTO getUser() {
		return user;
	}



	public void setUser(UserDTO user) {
		this.user = user;
	}



	public DonationDTO getDonation() {
		return donation;
	}



	public void setDonation(DonationDTO donation) {
		this.donation = donation;
	}
	
	
}
