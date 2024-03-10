package com.thiennh.springcrud.dao;

import com.thiennh.springcrud.entity.UserDonationEntity;

public interface UserDonationDAO {
	
	void saveUserDonation(UserDonationEntity userDonationEntity);
	
	void updateStatusOfUserDonation(Integer idUserDonation);

}
