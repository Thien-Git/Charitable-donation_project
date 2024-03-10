package com.thiennh.springcrud.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thiennh.springcrud.dao.RoleDao;
import com.thiennh.springcrud.entity.RoleEntity;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	public RoleDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<RoleEntity> getRoles() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<RoleEntity> theQuery = currentSession.createQuery("from RoleEntity", RoleEntity.class);
		List<RoleEntity> roles = theQuery.getResultList();
		return roles;
	}

	@Override
	public String getRoleNameById(Integer roleId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<String> theQuery = currentSession.createQuery("select r.roleName from RoleEntity r where r.id = :roleId",
				String.class);
		theQuery.setParameter("roleId", roleId);
		String roleName = theQuery.uniqueResult();
		return roleName;
	}

}
