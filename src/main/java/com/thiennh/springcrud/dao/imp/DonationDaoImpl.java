package com.thiennh.springcrud.dao.imp;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thiennh.springcrud.dao.DonationDao;
import com.thiennh.springcrud.entity.DonationEntity;
import com.thiennh.springcrud.entity.UserDonationEntity;

@Repository
public class DonationDaoImpl implements DonationDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public DonationDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
//	Phân trang
	@Override
	public List<DonationEntity> getListDonationHavePagination(Integer page, Integer pageSize) {
		if (page == null || pageSize == null) {
	        // Xử lý nếu page hoặc pageSize là null
	        return Collections.emptyList(); // hoặc throw exception tùy vào yêu cầu
	    }
		
//		Mấu chốt cần xử lý
//		page 1: select * from bảng order by x limit pageSize offset pageSize*0;
//		page 2: select * from bảng order by x limit pageSize offset pageSize*1;
//		page 3: select * from bảng order by x limit pageSize offset pageSize*2;
		
		Integer offset = page * pageSize;
		Session currentSession = sessionFactory.getCurrentSession();
		Query<DonationEntity> theQuery = currentSession.createQuery("from DonationEntity order by code asc",
				DonationEntity.class);
		theQuery.setFirstResult(offset); // thanks chat GPT
	    theQuery.setMaxResults(pageSize); // thanks chat GPT
		List<DonationEntity> donationEntities = theQuery.getResultList();
		return donationEntities;
	}
	
	

	@Override
	public List<DonationEntity> getListDonation() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<DonationEntity> theQuery = currentSession.createQuery("from DonationEntity", DonationEntity.class);
		List<DonationEntity> donationEntities = theQuery.getResultList();
		return donationEntities;
	}

	@Override
	public void saveDonation(DonationEntity donationEntity) {
		Session currSession = sessionFactory.getCurrentSession();
		currSession.save(donationEntity);
	}

	@Override
	public void deleteDonation(Integer id) {
		Session currSession = sessionFactory.getCurrentSession();
		Query theQuery = currSession.createQuery("delete from DonationEntity where id = :id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
	}

	@Override
	public DonationEntity getDonationById(Integer id) {
		Session currSession = sessionFactory.getCurrentSession();
		Query<DonationEntity> theQuery = currSession.createQuery("from DonationEntity where id = :id",
				DonationEntity.class);
		theQuery.setParameter("id", id);
		List<DonationEntity> list = theQuery.getResultList();
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void updateDonation(DonationEntity donationEntity) {
		Session currSession = sessionFactory.getCurrentSession();
		currSession.saveOrUpdate(donationEntity);
	}

	@Override
	public List<UserDonationEntity> getListUserDonation(Integer idDonation) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserDonationEntity> theQuery = currentSession
				.createQuery("from UserDonationEntity where donation.id = :idDonation", UserDonationEntity.class);
		theQuery.setParameter("idDonation", idDonation);
		List<UserDonationEntity> userDonationEntities = theQuery.getResultList();
		return userDonationEntities;
	}

	@Override
	public void updateStatusDonationToDangQuyenGop(Integer idDonation) {
//		Update table set truong = ... where id = xxx
		
//		Hiện đợt quên góp là đang quyên góp
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("update DonationEntity set status = 1 where id = :id");
		theQuery.setParameter("id", idDonation);
		theQuery.executeUpdate();
		
	}

	@Override
	public void updateStatusDonationToFinish(Integer idDonation) {
//		Update table set truong = ... where id = xxx
		
		
//		Hiện đợt quên góp là kết thúc quyên góp
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("update DonationEntity set status = 2 where id = :id");
		theQuery.setParameter("id", idDonation);
		theQuery.executeUpdate();
	}

	@Override
	public void updateStatusDonationToClose(Integer idDonation) {
//		Update table set truong = ... where id = xxx
		
		
//		Hiện đợt quên góp là đóng quyên góp
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("update DonationEntity set status = 3 where id = :id");
		theQuery.setParameter("id", idDonation);
		theQuery.executeUpdate();
		
	}

	

	
	

}
