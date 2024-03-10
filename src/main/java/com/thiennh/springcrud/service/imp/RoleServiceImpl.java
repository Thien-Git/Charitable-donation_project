package com.thiennh.springcrud.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiennh.springcrud.dao.RoleDao;
import com.thiennh.springcrud.dto.RoleDTO;
import com.thiennh.springcrud.entity.RoleEntity;
import com.thiennh.springcrud.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	@Autowired
	public RoleServiceImpl(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	@Transactional
	public List<RoleDTO> getRoles() {
		// Lay du lieu tu bang Role (RoleEntity) chuyen sang dang DTO
		List<RoleEntity> listRoleEntities = roleDao.getRoles();
		List<RoleDTO> listRoleDTOs = new ArrayList<RoleDTO>();
		
		for(int i = 0; i < listRoleEntities.size(); i++) {
			int id = listRoleEntities.get(i).getId();
			String roleName = listRoleEntities.get(i).getRoleName();
			
			RoleDTO roleDTO = new RoleDTO(id, roleName);
			listRoleDTOs.add(roleDTO);
		}
		return listRoleDTOs;
	}

}
