package com.shop.springboot.demo.motoshopdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.shop.springboot.demo.motoshopdemo.entity.Users;

public class UserRegisterDAOImpl implements UserRegisterDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Users findByUserName(String userName) {
		
		Session session = sessionFactory.getCurrentSession();
		
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
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theUsers);
		
	}
	
}
