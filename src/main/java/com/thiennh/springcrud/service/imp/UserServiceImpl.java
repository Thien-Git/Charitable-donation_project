package com.thiennh.springcrud.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiennh.springcrud.dao.RoleDao;
import com.thiennh.springcrud.dao.UserDao;
import com.thiennh.springcrud.dto.DonationDTO;
import com.thiennh.springcrud.dto.RoleDTO;
import com.thiennh.springcrud.dto.UserAddDto;
import com.thiennh.springcrud.dto.UserDTO;
import com.thiennh.springcrud.dto.UserDonationQuickDTO;
import com.thiennh.springcrud.dto.UserLoginDTO;
import com.thiennh.springcrud.dto.UserUpdateDTO;
import com.thiennh.springcrud.entity.DonationEntity;
import com.thiennh.springcrud.entity.RoleEntity;
import com.thiennh.springcrud.entity.UserDonationEntity;
import com.thiennh.springcrud.entity.UserEntity;
import com.thiennh.springcrud.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	private RoleDao roleDao;

	@Autowired
	public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
		this.userDao = userDao;
		this.roleDao = roleDao;
	}

	
//	Lấy list người dùng 
	
	@Override
	@Transactional
	public List<UserDTO> getList() {
//		Lấy ra list entity từ db
		List<UserEntity> listUserEntities = userDao.getUsers();
		List<UserDTO> listUserDTOs = new ArrayList<UserDTO>();

		
//		duyệt mỗi entity để tạo 1 dto và thêm vào list dto
		for (int i = 0; i < listUserEntities.size(); i++) {
			UserDTO userDTO = new UserDTO();

			userDTO.setId(listUserEntities.get(i).getId());
			userDTO.setFullName(listUserEntities.get(i).getFullName());
			userDTO.setEmail(listUserEntities.get(i).getEmail());
			userDTO.setPhoneNumber(listUserEntities.get(i).getPhoneNumber());
			userDTO.setUserName(listUserEntities.get(i).getUserName());
			userDTO.setPassword(listUserEntities.get(i).getPassword());

			Integer roleId = listUserEntities.get(i).getRole().getId();
			String roleName = listUserEntities.get(i).getRole().getRoleName();

			RoleDTO roleDTO = new RoleDTO(roleId, roleName);

			userDTO.setRole(roleDTO);

			userDTO.setStatus(listUserEntities.get(i).getStatus());
			userDTO.setAddress(listUserEntities.get(i).getAddress());
			userDTO.setCreatedAt(listUserEntities.get(i).getCreatedAt());
			userDTO.setNote(listUserEntities.get(i).getNote());

			listUserDTOs.add(userDTO);
		}
		
//		trả ra list DTO
		return listUserDTOs;
	}

	
//	Lưu thông tin người dùng mới tạo
	
	@Override
	@Transactional
	public void saveUser(UserAddDto userAddDto) {

		// Map DTO sang Entity
		UserEntity userEntity = new UserEntity();

		userEntity.setFullName(userAddDto.getFullName());
		userEntity.setEmail(userAddDto.getEmail());
		userEntity.setPhoneNumber(userAddDto.getPhoneNumber());
		userEntity.setAddress(userAddDto.getAddress());
		userEntity.setUserName(userAddDto.getUserName());
		userEntity.setPassword(userAddDto.getPassword());
		userEntity.setCreatedAt(userAddDto.getCreatedAt());
		// set status = 1 de hoat dong (set mặc định)
		userEntity.setStatus(1);

		// Tạo RoleEntity
		Integer roleId = userAddDto.getRoleId();
		String roleName = roleDao.getRoleNameById(roleId);
		RoleEntity roleEntity = new RoleEntity(roleId, roleName);

		userEntity.setRole(roleEntity);

		userDao.saveUser(userEntity);
	}

	
//	update status để khóa
	
	@Override
	@Transactional
	public void updateStatusToLock(Integer id) {
		userDao.updateStatusToLock(id);
	}

	
//	update status để mở
	
	@Override
	@Transactional
	public void updateStatusToUnLock(Integer id) {
		userDao.updateStatusToUnLock(id);
		
	}

	
//	Xóa 1 người dùng
	
	@Override
	@Transactional
	public void deleteUser(Integer id) {
		userDao.deleteUser(id);
		
	}

	
//	Lấy thông tin 1 người dùng cần update bằng id
	
	@Override
	@Transactional
	public UserUpdateDTO getUserById(Integer id) {
//		Lấy ra entity từ db
		UserEntity userEntity = userDao.getUserById(id);
		
		UserUpdateDTO userNeedUpdateDTO = new UserUpdateDTO();
		
//		chuyển data từ entity sang dto
		userNeedUpdateDTO.setId(userEntity.getId());
		userNeedUpdateDTO.setFullName(userEntity.getFullName());
		userNeedUpdateDTO.setEmail(userEntity.getEmail());
		userNeedUpdateDTO.setPhoneNumber(userEntity.getPhoneNumber());
		userNeedUpdateDTO.setAddress(userEntity.getAddress());
		userNeedUpdateDTO.setUserName(userEntity.getUserName());
		
		Integer idRole = userEntity.getRole().getId();
		
		userNeedUpdateDTO.setRoleId(idRole);
		
		userNeedUpdateDTO.setStatus(userEntity.getStatus());
		userNeedUpdateDTO.setNote(userEntity.getNote());
		userNeedUpdateDTO.setPassword(userEntity.getPassword());
		userNeedUpdateDTO.setCreatedAt(userEntity.getCreatedAt());
		
		
//		trả ra dto
		return userNeedUpdateDTO;
	}

	
	
//	Xử lý Cập nhật người dùng vào db
	
	@Override
	@Transactional
	public void updateUser(UserUpdateDTO userNeedUpdate) {
		UserEntity userEntity = new UserEntity();
		
		
//		lấy dữ liệu từ userNeedUpdate (được truyền từ controller vào) chuyển sáng entity
		userEntity.setId(userNeedUpdate.getId());
		userEntity.setFullName(userNeedUpdate.getFullName());
		userEntity.setEmail(userNeedUpdate.getEmail());
		userEntity.setPhoneNumber(userNeedUpdate.getPhoneNumber());
		userEntity.setAddress(userNeedUpdate.getAddress());
		userEntity.setUserName(userNeedUpdate.getUserName());
		
		Integer idRole = userNeedUpdate.getRoleId();
		String roleName = roleDao.getRoleNameById(idRole);
		RoleEntity roleEntity = new RoleEntity(idRole, roleName);
		userEntity.setRole(roleEntity);//tạo được role
		
		userEntity.setStatus(userNeedUpdate.getStatus());
		userEntity.setCreatedAt(userNeedUpdate.getCreatedAt());
		userEntity.setPassword(userNeedUpdate.getPassword());
		userEntity.setNote(userNeedUpdate.getNote());
		
//		cập nhật dữ liệu vào db
		userDao.updateUser(userEntity);
	}

	
	
//	Kiểm tra thông tin người đăng nhập có trong DB không, nếu có thì trả ra thông tin người đó đầy đủ
	
	@Override
	@Transactional
	public UserLoginDTO getUserCheckLogin(String email, String password) {
		UserEntity userEntity = userDao.getUserCheckLogin(email, password);
		
		if(userEntity == null) {
			return null;
		} else {
			UserLoginDTO userLoginDTO = new UserLoginDTO();
			userLoginDTO.setId(userEntity.getId());
			userLoginDTO.setEmail(userEntity.getEmail());
			userLoginDTO.setPassword(userEntity.getPassword());
			userLoginDTO.setFullName(userEntity.getFullName());
			userLoginDTO.setRoleId(userEntity.getRole().getId());
			userLoginDTO.setStatus(userEntity.getStatus());
			
			return userLoginDTO;
		}
		
	}
	
	

//	Lấy ra user bằng id
	
	@Override
	@Transactional
	public UserDTO getUserDTOById(Integer id) {
//		lấy ra userEntity từ DB
		UserEntity userEntity = userDao.getUserById(id);
		
		UserDTO userDTO = new UserDTO();//cần tạo 1 user để trả ra Controller
		
		userDTO.setId(userEntity.getId());
		userDTO.setFullName(userEntity.getFullName());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setPhoneNumber(userEntity.getPhoneNumber());
		userDTO.setUserName(userEntity.getUserName());
		userDTO.setAddress(userEntity.getAddress());
		userDTO.setStatus(userEntity.getStatus());
		userDTO.setCreatedAt(userEntity.getCreatedAt());
		userDTO.setNote(userEntity.getNote());
		userDTO.setPassword(userEntity.getPassword());
		
		Integer idRole = userEntity.getRole().getId();
		String roleName = userEntity.getRole().getRoleName();
		RoleDTO roleDTO = new RoleDTO(idRole, roleName);
		
		userDTO.setRole(roleDTO);
		
//		tạo xong userDTO, trả ra controller
		return userDTO;
	}
	
	



}
