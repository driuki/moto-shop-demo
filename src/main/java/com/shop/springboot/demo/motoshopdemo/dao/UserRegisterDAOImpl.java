package com.shop.springboot.demo.motoshopdemo.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.shop.springboot.demo.motoshopdemo.entity.Users;

public class UserRegisterDAOImpl implements UserRegisterDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public UserRegisterDAOImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}
	
	@Override
	public Users findByUserName(String userName) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Users> theQuery = session.createQuery("FROM Users WHERE username=:userName", Users.class);
		
		theQuery.setParameter("userName", userName);
		
		Users theUsers = null;
		
		try {
			theUsers = theQuery.getSingleResult();
		} catch (Exception e) {
			theUsers = null;
		}
		
		return theUsers;
	}

	@Override
	public void save(Users theUsers) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(theUsers);
		
	}
	
}
