package com.thiennh.springcrud.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_donation")
public class UserDonationEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "created")
	private String created;

	@Column(name = "money")
	private Integer money;

	@Column(name = "name")
	private String name;

	@Column(name = "status")
	private Integer status;  // = 1 là đã được xác nhận, = 0 là chưa được xác nhận 

	@Column(name = "text")
	private String text;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "donation_id")
	private DonationEntity donation;

	public UserDonationEntity(String created, Integer money, String name, Integer status, String text) {
		this.created = created;
		this.money = money;
		this.name = name;
		this.status = status;
		this.text = text;
	}
	
	

	public UserDonationEntity(Integer id, String created, Integer money, String name, Integer status, String text,
			UserEntity user, DonationEntity donation) {
		this.created = created;
		this.money = money;
		this.name = name;
		this.status = status;
		this.text = text;
		this.user = user;
		this.donation = donation;
	}



	public UserDonationEntity() {
	}

	public int getId() {
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

	public int getMoney() {
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

	public int getStatus() {
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public DonationEntity getDonation() {
		return donation;
	}

	public void setDonation(DonationEntity donation) {
		this.donation = donation;
	}
	
	

	
	

}
