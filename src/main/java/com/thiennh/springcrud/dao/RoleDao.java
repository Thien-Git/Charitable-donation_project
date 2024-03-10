package com.thiennh.springcrud.dao;

import java.util.List;

import com.thiennh.springcrud.entity.RoleEntity;

public interface RoleDao {
	List<RoleEntity> getRoles();

	String getRoleNameById(Integer roleId);

}
