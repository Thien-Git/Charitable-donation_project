package com.thiennh.springcrud.service.imp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiennh.springcrud.dao.UserDonationDAO;
import com.thiennh.springcrud.dto.DonationDTO;
import com.thiennh.springcrud.dto.UserDTO;
import com.thiennh.springcrud.dto.UserDonationDTO;
import com.thiennh.springcrud.entity.DonationEntity;
import com.thiennh.springcrud.entity.RoleEntity;
import com.thiennh.springcrud.entity.UserDonationEntity;
import com.thiennh.springcrud.entity.UserEntity;
import com.thiennh.springcrud.service.UserDonationService;
@Service
public class UserDonationServiceImpl implements UserDonationService {
	
	@Autowired
	private UserDonationDAO userDonationDAO;
	
	@Autowired
	public UserDonationServiceImpl(UserDonationDAO userDonationDAO) {
		this.userDonationDAO = userDonationDAO;
	}


//	Xử lý thêm vào database thông tin 1 người quyên góp nhanh
	
	@Override
	@Transactional
	public void addUserQuickDonation(String name, Integer money, String text, 
									String created, Integer status, 
									UserDTO userDTO, DonationDTO donationDTO) {
		
		UserDonationEntity userDonationEntity = new UserDonationEntity();
		
		UserEntity userEntity = new UserEntity();
		DonationEntity donationEntity = new DonationEntity();
		
//		Chuyển data từ userDTO sang userEntity 
//		=> tạo userEntity
		userEntity.setId(userDTO.getId());
		userEntity.setAddress(userDTO.getAddress());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setFullName(userDTO.getFullName());
		userEntity.setNote(userDTO.getNote());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setPhoneNumber(userDTO.getPhoneNumber());
		userEntity.setStatus(userDTO.getStatus());
		userEntity.setUserName(userDTO.getUserName());
		userEntity.setCreatedAt(userDTO.getCreatedAt());
		
//		Tạo role Entity
		Integer roleId = userDTO.getRole().getId();
		String roleName = userDTO.getRole().getRoleName();
		RoleEntity roleEntity = new RoleEntity(roleId, roleName);
		
		userEntity.setRole(roleEntity);
//		=> tạo userEntity (xong)
		
		//		Chuyển data từ donationDTO sang donationEntity 
//		=> tạo donationEntity
		donationEntity.setId(donationDTO.getId());
		donationEntity.setCode(donationDTO.getCode());
		donationEntity.setCreated(donationDTO.getCreated());
		donationEntity.setDescription(donationDTO.getDescription());
		donationEntity.setEndDate(donationDTO.getEndDate());
		donationEntity.setMoney(donationDTO.getMoney());
		donationEntity.setName(donationDTO.getName());
		donationEntity.setOrganizationName(donationDTO.getOrganizationName());
		donationEntity.setPhoneNumber(donationDTO.getPhoneNumber());
		donationEntity.setStartDate(donationDTO.getStartDate());
		donationEntity.setStatus(donationDTO.getStatus());
		
//		tạo list userDonation (ko cần-xóa r)
//		=> tạo donationEntity (xong)
		
		
		
//		Thêm dữ liệu vào bảng trung gian userDonationEntity
		userDonationEntity.setCreated(created);
		userDonationEntity.setMoney(money);
		userDonationEntity.setName(name);
		userDonationEntity.setText(text);
		if(status == null) {
			status = 0; //chờ xác nhận
		} else {
			status = 1; //đã được xác nhận
		}
		userDonationEntity.setStatus(status);
		userDonationEntity.setUser(userEntity);
		userDonationEntity.setDonation(donationEntity);

//		gọi DAO để đẩy dữ liệu userDonationEntity vào DB
		userDonationDAO.saveUserDonation(userDonationEntity);
		
		
	}

	
//	Cập nhật lại status của bản ghi đó (update..status..where id = .... đưa status về 1 là đã dc xác nhận(status ở bảng user_donation)
	
	@Override
	@Transactional
	public void updateStatusOfUserDonation(Integer idUserDonation) {
		userDonationDAO.updateStatusOfUserDonation(idUserDonation);
	}

}



























