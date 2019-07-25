package com.shop.springboot.demo.motoshopdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.springboot.demo.motoshopdemo.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
//	@Autowired
//	private SessionFactory sessionFactory;
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Product> getProducts() {
		
		Session session = entityManager.unwrap(Session.class);
		
//		Session session = sessionFactory.getCurrentSession();
		
		Query<Product> theQuery =
				session.createQuery("FROM Product", Product.class);
		
		List<Product> products = theQuery.getResultList();
		
		return products;
	}

	@Override
	public Product getProductById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
//		Session session = sessionFactory.getCurrentSession();
		
		Product theProduct = session.get(Product.class, id);
		
		return theProduct;
	}

	@Override
	public void saveUpdateProduct(Product theProduct) {
		
		Session session = entityManager.unwrap(Session.class);
		
//		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theProduct);
		
	}

	@Override
	public void deleteProduct(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
//		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		Query<Product> theQuery =
				session.createQuery("DELETE FROM Product WHERE id=:theId");
		
		theQuery.setParameter("theId", id);
		
		theQuery.executeUpdate();
		
	}
	
}
