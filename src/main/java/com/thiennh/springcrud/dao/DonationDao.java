package com.thiennh.springcrud.dao;

import java.util.List;

import com.thiennh.springcrud.entity.DonationEntity;
import com.thiennh.springcrud.entity.UserDonationEntity;

public interface DonationDao {
	
	List<DonationEntity> getListDonation();
	
	void saveDonation(DonationEntity donationEntity);
	
	void deleteDonation(Integer id);

	DonationEntity getDonationById(Integer id);
	
	void updateDonation(DonationEntity donationEntity);
	
	List<UserDonationEntity> getListUserDonation(Integer id);
	
	void updateStatusDonationToDangQuyenGop(Integer idDonation);
	
	void updateStatusDonationToFinish(Integer idDonation);
	
	void updateStatusDonationToClose(Integer idDonation);
	
//	phân trang
	List<DonationEntity> getListDonationHavePagination(Integer page, Integer pageSize);
}
