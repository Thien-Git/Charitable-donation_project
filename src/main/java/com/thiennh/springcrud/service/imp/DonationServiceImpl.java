package com.thiennh.springcrud.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiennh.springcrud.dao.DonationDao;
import com.thiennh.springcrud.dto.DonationCategoryDTO;
import com.thiennh.springcrud.dto.DonationDTO;
import com.thiennh.springcrud.dto.DonationDetailDTO;
import com.thiennh.springcrud.dto.DonationUpdateDTO;
import com.thiennh.springcrud.dto.UserDonationDTO;
import com.thiennh.springcrud.entity.DonationEntity;
import com.thiennh.springcrud.entity.UserDonationEntity;
import com.thiennh.springcrud.service.DonationService;
@Service
public class DonationServiceImpl implements DonationService {
	
	@Autowired
	private DonationDao donationDao;
	
	@Autowired
	public DonationServiceImpl(DonationDao donationDao) {
		this.donationDao = donationDao;
	}
	
	
//	Lấy danh sách những donation

	@Override
	@Transactional
	public List<DonationDTO> getListDonation() {
		List<DonationEntity> donationEntities = donationDao.getListDonation();
		List<DonationDTO> donationDTOs = new ArrayList<DonationDTO>();
		
		for(int i = 0; i < donationEntities.size(); i++) {
			
//			Với mỗi 1 donationEntity lấy ra idDonation, từ idDonation sẽ duyệt 
//			hết tất cả user đang có tính ra tổng và set vào hàm setMoney
			Integer idDonation = donationEntities.get(i).getId();
			
//			Lấy ra danh sách user tương ứng với donation có id = idDonation
			List<UserDonationEntity> userDonationEntities = donationDao.getListUserDonation(idDonation);
			
//			Tính tổng tiền
//			Duyệt danh sách lấy từng money cộng lại
//			Kiểm tra status của người quyên góp trong bảng trung gian nếu = 0 thì không tính vào, 
//			= 1 thì tính vào (sự xác nhận của admin)
			Integer totalMoney = 0;
			for(int j = 0; j< userDonationEntities.size(); j++) {
				if(userDonationEntities.get(j).getStatus() ==  1) {
					totalMoney += userDonationEntities.get(j).getMoney();
				}
			}
			DonationDTO donationDTO = new DonationDTO();
			donationDTO.setId(donationEntities.get(i).getId());
			donationDTO.setCode(donationEntities.get(i).getCode());
			donationDTO.setCreated(donationEntities.get(i).getCreated());
			donationDTO.setDescription(donationEntities.get(i).getDescription());
			donationDTO.setEndDate(donationEntities.get(i).getEndDate());
			
			donationDTO.setMoney(totalMoney);
			
			donationDTO.setName(donationEntities.get(i).getName());
			donationDTO.setOrganizationName(donationEntities.get(i).getOrganizationName());
			donationDTO.setPhoneNumber(donationEntities.get(i).getPhoneNumber());
			donationDTO.setStartDate(donationEntities.get(i).getStartDate());
			donationDTO.setStatus(donationEntities.get(i).getStatus());
			
			donationDTOs.add(donationDTO);
		}
		return donationDTOs;
	}

//	Lưu donation

	@Override
	@Transactional
	public void saveDonation(DonationDTO donationDTO) {
		
		DonationEntity donationEntity = new DonationEntity();
		
//		Chuyển dữ liệu vào entity
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
		
		donationDao.saveDonation(donationEntity);
	}

//	Xóa 1 donation
	
	@Override
	@Transactional
	public void deleteDonation(Integer id) {
		donationDao.deleteDonation(id);
	}
	
	
//	Lấy ra thông tin donatino cần update
	
	@Override
	@Transactional
	public DonationUpdateDTO getDonationById(Integer id) {
		
//		Lấy ra entity
		DonationEntity donationEntity =  donationDao.getDonationById(id);
		
		DonationUpdateDTO donationUpdateDTO = new DonationUpdateDTO();
		
//		Lấy dữ liệu từ Entity ra
		donationUpdateDTO.setId(donationEntity.getId());
		donationUpdateDTO.setCode(donationEntity.getCode());
		donationUpdateDTO.setName(donationEntity.getName());
		donationUpdateDTO.setStartDate(donationEntity.getStartDate());
		donationUpdateDTO.setEndDate(donationEntity.getEndDate());
		donationUpdateDTO.setOrganizationName(donationEntity.getOrganizationName());
		donationUpdateDTO.setPhoneNumber(donationEntity.getPhoneNumber());
		donationUpdateDTO.setDescription(donationEntity.getDescription());
		
		donationUpdateDTO.setCreated(donationEntity.getCreated());
		donationUpdateDTO.setMoney(donationEntity.getMoney());
		donationUpdateDTO.setStatus(donationEntity.getStatus());
		
		return donationUpdateDTO;
	}

	
//	Xử lý update donation
	
	@Override
	@Transactional
	public void updateDonation(DonationUpdateDTO donationUpdateDTO) {
		DonationEntity donationEntity = new DonationEntity();
		
//		Set thông tin mới vào Entity
		donationEntity.setId(donationUpdateDTO.getId());
		donationEntity.setCreated(donationUpdateDTO.getCreated());
		donationEntity.setMoney(donationUpdateDTO.getMoney());
		donationEntity.setStatus(donationUpdateDTO.getStatus());
		donationEntity.setCode(donationUpdateDTO.getCode());
		donationEntity.setName(donationUpdateDTO.getName());
		donationEntity.setStartDate(donationUpdateDTO.getStartDate());
		donationEntity.setEndDate(donationUpdateDTO.getEndDate());
		donationEntity.setOrganizationName(donationUpdateDTO.getOrganizationName());
		donationEntity.setPhoneNumber(donationUpdateDTO.getPhoneNumber());
		donationEntity.setDescription(donationUpdateDTO.getDescription());
		
		
		donationDao.updateDonation(donationEntity);
		
	}

	
//	Chi tiết 1 donation
	@Override
	@Transactional
	public DonationDetailDTO getDonationDetail(Integer id) {
//		Lấy ra donation cần xem chi tiết
		DonationEntity donationEntity =  donationDao.getDonationById(id);
		
		DonationDetailDTO donationDetailDTO = new DonationDetailDTO();
		
//		Chuyển dữ liệu vào DTO
		donationDetailDTO.setId(donationEntity.getId());
		donationDetailDTO.setCode(donationEntity.getCode());
		donationDetailDTO.setName(donationEntity.getName());
		donationDetailDTO.setStartDate(donationEntity.getStartDate());
		donationDetailDTO.setEndDate(donationEntity.getEndDate());
		donationDetailDTO.setOrganizationName(donationEntity.getOrganizationName());
		donationDetailDTO.setPhoneNumber(donationEntity.getPhoneNumber());
		donationDetailDTO.setDescription(donationEntity.getDescription());
		
		donationDetailDTO.setCreated(donationEntity.getCreated());
		donationDetailDTO.setStatus(donationEntity.getStatus());
		
		donationDetailDTO.setTotalMoney(donationEntity.getMoney());
		
		return donationDetailDTO;
		
	}
	
	
//	Lấy thông tin những người quyên góp

	@Override
	@Transactional
	public List<UserDonationDTO> getListUserDonation(Integer idDonation) {
		
		List<UserDonationEntity> userDonationEntities =  donationDao.getListUserDonation(idDonation);
		
		List<UserDonationDTO> userDonationDTOs = new ArrayList<UserDonationDTO>();
		
//		duyệt mỗi entity để tạo 1 dto rồi thêm dto đó vào list
		for(int i = 0; i < userDonationEntities.size(); i++) {
			UserDonationDTO userDonationDTO = new UserDonationDTO();
			
			userDonationDTO.setId(userDonationEntities.get(i).getId());
			userDonationDTO.setCreated(userDonationEntities.get(i).getCreated());
			userDonationDTO.setMoney(userDonationEntities.get(i).getMoney());
			userDonationDTO.setName(userDonationEntities.get(i).getName());
			userDonationDTO.setStatus(userDonationEntities.get(i).getStatus());
			userDonationDTO.setText(userDonationEntities.get(i).getText());
			
			userDonationDTOs.add(userDonationDTO);
		}
//		trả ra list người quyên góp (DTO)
		return userDonationDTOs;
	}

	
//	Lấy các đầu mục... của Donation để làm trang home của người dùng
	
	@Override
	@Transactional
	public List<DonationCategoryDTO> getCategory() {
		List<DonationEntity> donationEntities = donationDao.getListDonation();
		
		List<DonationCategoryDTO> donationCategoryDTOs  = new ArrayList<>();
		
		for(int i = 0; i < donationEntities.size(); i++) {
			
			DonationCategoryDTO donationCategoryDTO = new DonationCategoryDTO();
			
			donationCategoryDTO.setId(donationEntities.get(i).getId());
			donationCategoryDTO.setName(donationEntities.get(i).getName());
			donationCategoryDTO.setStartDate(donationEntities.get(i).getStartDate());
			donationCategoryDTO.setEndDate(donationEntities.get(i).getEndDate());
			donationCategoryDTO.setOrganizationName(donationEntities.get(i).getOrganizationName());
			donationCategoryDTO.setPhoneNumber(donationEntities.get(i).getPhoneNumber());
			donationCategoryDTO.setStatus(donationEntities.get(i).getStatus());
			
			donationCategoryDTOs.add(donationCategoryDTO);
		}
		
//		trả ra cho UserController (user/home)
		return donationCategoryDTOs;
	}

	
//	Lấy Donation theo id
	
	@Override
	@Transactional
	public DonationDTO getDonationDTOById(Integer id) {
		DonationEntity donationEntity = donationDao.getDonationById(id);
		
		DonationDTO donationDTO = new DonationDTO();
		
		donationDTO.setCode(donationEntity.getCode());
		donationDTO.setCreated(donationEntity.getCreated());
		donationDTO.setDescription(donationEntity.getDescription());
		donationDTO.setEndDate(donationEntity.getEndDate());
		donationDTO.setId(donationEntity.getId());
		donationDTO.setMoney(donationEntity.getMoney());
		donationDTO.setName(donationEntity.getName());
		donationDTO.setOrganizationName(donationEntity.getOrganizationName());
		donationDTO.setPhoneNumber(donationEntity.getPhoneNumber());
		donationDTO.setStartDate(donationEntity.getStartDate());
		donationDTO.setStatus(donationEntity.getStatus());
		
//		trả ra controller chỗ quyên góp nhanh
		return donationDTO;
	}

//	Cập nhật status donation để hiện thành "đang quyên góp"
	
	@Override
	@Transactional
	public void updateStatusDonationToDangQuyenGop(Integer idDonation) {
		donationDao.updateStatusDonationToDangQuyenGop(idDonation);
	}
	
//	Cập nhật status donation để hiện thành "kết thúc quyên góp"

	@Override
	@Transactional
	public void updateStatusDonationToFinish(Integer idDonation) {
		donationDao.updateStatusDonationToFinish(idDonation);
		
	}
	
	@Override
	@Transactional
	public void updateStatusDonationToClose(Integer idDonation) {
		donationDao.updateStatusDonationToClose(idDonation);
		
	}


//	phân trang
	@Override
	@Transactional
	public List<DonationDTO> getListDonationHavePagination(Integer page, Integer pageSize) {
		List<DonationEntity> donationEntities = donationDao.getListDonationHavePagination(page, pageSize);
		
		List<DonationDTO> donationDTOs = new ArrayList<>();
		
		for(int i = 0; i < donationEntities.size(); i++) {
			
			DonationDTO donationDTO = new DonationDTO();
			
			donationDTO.setId(donationEntities.get(i).getId());
			donationDTO.setName(donationEntities.get(i).getName());
			donationDTO.setStartDate(donationEntities.get(i).getStartDate());
			donationDTO.setEndDate(donationEntities.get(i).getEndDate());
			donationDTO.setOrganizationName(donationEntities.get(i).getOrganizationName());
			donationDTO.setPhoneNumber(donationEntities.get(i).getPhoneNumber());
			donationDTO.setStatus(donationEntities.get(i).getStatus());
			
			donationDTOs.add(donationDTO);
		}
		return donationDTOs;
	}


	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
