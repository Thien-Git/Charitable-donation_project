package com.thiennh.springcrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donation")
public class DonationEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "code")
	private String code;

	@Column(name = "created")
	private String created;

	@Column(name = "description")
	private String description;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "money")
	private Integer money;

	@Column(name = "name")
	private String name;

	@Column(name = "organization_name")
	private String organizationName;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "status")
	private Integer status; // để làm gì, có phải xác định đang mở hay kết thúc 
	//(mới tạo null, đang quyên 1, kết thúc 2,  đóng 3...)

	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") private
	 * List<UserDonationEntity> userDonations;
	 */
	
	

	public DonationEntity() {
	}

	public DonationEntity(String code, String created, String description, String endDate, Integer money, String name,
			String organizationName, String phoneNumber, String startDate, Integer status) {
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
