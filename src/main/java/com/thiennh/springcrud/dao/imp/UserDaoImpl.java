package com.thiennh.springcrud.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thiennh.springcrud.dao.UserDao;
import com.thiennh.springcrud.entity.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<UserEntity> getUsers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserEntity> theQuery = currentSession.createQuery("from UserEntity", UserEntity.class);
		List<UserEntity> users = theQuery.getResultList();
		return users;
	}

	@Override
	public void saveUser(UserEntity userEntity) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(userEntity);
	}
	
	@Override
	public void updateStatusToLock(Integer id) {
	    Session currentSession = sessionFactory.getCurrentSession();
	    Query theQuery = currentSession.createQuery("update UserEntity set status = 0 where id = :id");
	    theQuery.setParameter("id", id);
	    theQuery.executeUpdate();
	}

	@Override
	public void updateStatusToUnLock(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
	    Query theQuery = currentSession.createQuery("update UserEntity set status = 1 where id = :id");
	    theQuery.setParameter("id", id);
	    theQuery.executeUpdate();
	}

	@Override
	public void deleteUser(Integer id) {
		Session currSession = sessionFactory.getCurrentSession();
		Query theQuery = currSession.createQuery("delete from UserEntity where id = :id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
	}
	
	@Override
	public UserEntity getUserById(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserEntity> theQuery = currentSession.createQuery("from UserEntity where id = :id", UserEntity.class);
		theQuery.setParameter("id", id);
		List<UserEntity> userEntitys = theQuery.getResultList();
		
		if(!userEntitys.isEmpty()) {
			return userEntitys.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void updateUser(UserEntity theUser) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public UserEntity getUserCheckLogin(String email, String password) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<UserEntity> theQuery = currentSession.createQuery("from UserEntity where email = :email and password = :password", UserEntity.class);
		theQuery.setParameter("email", email);
		theQuery.setParameter("password", password);
		
		List<UserEntity> userEntitys = theQuery.getResultList();
		
		if(!userEntitys.isEmpty()) {
			return userEntitys.get(0);
		} else {
			return null;
		}
	}

	

}
