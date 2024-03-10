package com.thiennh.springcrud.service;

import java.util.List;

import com.thiennh.springcrud.dto.UserDTO;
import com.thiennh.springcrud.dto.UserDonationQuickDTO;
import com.thiennh.springcrud.dto.UserLoginDTO;
import com.thiennh.springcrud.dto.UserUpdateDTO;
import com.thiennh.springcrud.dto.DonationDTO;
import com.thiennh.springcrud.dto.UserAddDto;

public interface UserService {

	List<UserDTO> getList();

	void saveUser(UserAddDto userRegisterDto);
	
	void updateStatusToLock(Integer id);
	
	void updateStatusToUnLock(Integer id);
	
	void deleteUser(Integer id);

	UserUpdateDTO getUserById(Integer id);
	
	void updateUser(UserUpdateDTO userNeedUpdate);
	
	UserLoginDTO getUserCheckLogin(String email, String password);
	
	UserDTO getUserDTOById(Integer id);
	
	
	

}
