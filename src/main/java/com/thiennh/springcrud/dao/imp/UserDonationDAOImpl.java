package com.thiennh.springcrud.dao.imp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.thiennh.springcrud.dao.UserDonationDAO;
import com.thiennh.springcrud.entity.UserDonationEntity;
@Repository
public class UserDonationDAOImpl implements UserDonationDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public UserDonationDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveUserDonation(UserDonationEntity userDonationEntity) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(userDonationEntity);
	}
	
//	cập nhật status của bảng trung gian thành 1 là đã xác nhận quyên góp

	@Override
	public void updateStatusOfUserDonation(Integer idUserDonation) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("update UserDonationEntity set status = 1 where id = :id");
	    theQuery.setParameter("id", idUserDonation);
	    theQuery.executeUpdate();
	}

}
