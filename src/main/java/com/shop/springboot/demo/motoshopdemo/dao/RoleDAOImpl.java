package com.shop.springboot.demo.motoshopdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.shop.springboot.demo.motoshopdemo.entity.Role;

public class RoleDAOImpl implements RoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Role findRoleByName(String theRoleName) {
		
		Session session = sessionFactory.getCurrentSession();
		
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
