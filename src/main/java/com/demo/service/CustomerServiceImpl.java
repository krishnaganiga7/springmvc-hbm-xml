package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.CustomerDAO;
import com.demo.entity.Customer;
@Service("customerService")
//@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	CustomerDAO customerDAO;
	@Override
	public List<Customer> viewAll() {
		return customerDAO.viewAll();
		
	}

	
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Service"+" "+customer);
		
		
		customerDAO.saveCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerById(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);

	}

}
