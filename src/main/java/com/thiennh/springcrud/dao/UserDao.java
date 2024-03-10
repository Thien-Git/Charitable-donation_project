package com.thiennh.springcrud.dao;

import java.util.List;

import com.thiennh.springcrud.entity.UserEntity;

public interface UserDao {
	
	public List<UserEntity> getUsers();

	public void saveUser(UserEntity theUser);
	
	void updateStatusToLock(Integer id);
	
	void updateStatusToUnLock(Integer id);
	
	void deleteUser(Integer id);
	
	UserEntity getUserById(Integer id);
	
	void updateUser(UserEntity theUser);
	
	UserEntity getUserCheckLogin(String email, String password);

}
