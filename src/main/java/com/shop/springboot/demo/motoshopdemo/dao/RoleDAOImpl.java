package com.shop.springboot.demo.motoshopdemo.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.springboot.demo.motoshopdemo.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public RoleDAOImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}
	
	@Override
	public Role findRoleByName(String theRoleName) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Role> theQuery = session.createQuery("FROM Role WHERE role=:roleName", Role.class);
		
		theQuery.setParameter("roleName", theRoleName);
		
		Role theRole = null;
		
		try {
			theRole = theQuery.getSingleResult();
		} catch (Exception e) {
			theRole = null;
		}
		
		return theRole;
	
	}

}
