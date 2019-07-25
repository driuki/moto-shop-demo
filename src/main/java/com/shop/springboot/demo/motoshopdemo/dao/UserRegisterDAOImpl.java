package com.shop.springboot.demo.motoshopdemo.dao;

import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.springboot.demo.motoshopdemo.entity.Users;

@Repository
public class UserRegisterDAOImpl implements UserRegisterDAO {
	
//	@Autowired
//	private SessionFactory sessionFactory;
	
	@Autowired
	private EntityManager entityManager;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Override
	public Users findByUserName(String userName) {
		
		Session session = entityManager.unwrap(Session.class);
		
//		Session session = sessionFactory.getCurrentSession();
		
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
		
		logger.info("\n\nSaving le dao");
		
		Session session = entityManager.unwrap(Session.class);
		
//		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theUsers);
		
		logger.info("\n\nSaved le dao");
		
	}
	
}
