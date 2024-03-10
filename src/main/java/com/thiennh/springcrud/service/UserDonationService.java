package com.thiennh.springcrud.service;

import com.thiennh.springcrud.dto.DonationDTO;
import com.thiennh.springcrud.dto.UserDTO;
import com.thiennh.springcrud.dto.UserDonationDTO;

public interface UserDonationService {
	
	void addUserQuickDonation(String name, Integer money, String text, String created, Integer status, UserDTO userDTO, DonationDTO donationDTO) ;

	void updateStatusOfUserDonation(Integer idUserDonation);
}
