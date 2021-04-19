package com.demo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Customer;
//@Transactional
@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Customer> viewAll() {
		Session session=sessionFactory.openSession();
		Query query= session.createQuery("from Customer");
		List<Customer> list = query.list();
		
		return list;
		
	}


	public void saveCustomer(Customer customer) {
		System.out.println("DAo"+" "+customer);
		
		Session session=sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
//		Query query= session.createQuery("from Customer where id=:cid");
//		query.setParameter("cid", id);
		Customer customer=session.get(Customer.class, id);
		return customer;
		
		
	}

	@Override
	public void deleteCustomer(int id) {
		Session session= sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Customer customer=this.getCustomerById(id);
		session.delete(customer);
//		tx.commit();

	}

}
