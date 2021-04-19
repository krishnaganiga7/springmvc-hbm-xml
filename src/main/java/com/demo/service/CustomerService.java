package com.demo.service;

import java.util.List;

import com.demo.entity.Customer;

public interface CustomerService {
	
	public List<Customer>  viewAll();
	public void saveCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public void deleteCustomer(int id);

}
