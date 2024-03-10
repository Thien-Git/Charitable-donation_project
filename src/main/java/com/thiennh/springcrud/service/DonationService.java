package com.thiennh.springcrud.service;

import java.util.List;

import com.thiennh.springcrud.dto.DonationCategoryDTO;
import com.thiennh.springcrud.dto.DonationDTO;
import com.thiennh.springcrud.dto.DonationDetailDTO;
import com.thiennh.springcrud.dto.DonationUpdateDTO;
import com.thiennh.springcrud.dto.UserDonationDTO;

public interface DonationService {

	List<DonationDTO> getListDonation();

	void saveDonation(DonationDTO donationDTO);

	void deleteDonation(Integer id);

	DonationUpdateDTO getDonationById(Integer id);

	void updateDonation(DonationUpdateDTO donationUpdateDTO);

	DonationDetailDTO getDonationDetail(Integer id);

	List<UserDonationDTO> getListUserDonation(Integer id); // để sang bên DonationService hợp lý hơn (sửa sau)

	List<DonationCategoryDTO> getCategory();

	DonationDTO getDonationDTOById(Integer id);

	void updateStatusDonationToDangQuyenGop(Integer idDonation);

	void updateStatusDonationToFinish(Integer idDonation);
	
	void updateStatusDonationToClose(Integer idDonation);

//	paging
	List<DonationDTO> getListDonationHavePagination(Integer page, Integer pageSize);

}
