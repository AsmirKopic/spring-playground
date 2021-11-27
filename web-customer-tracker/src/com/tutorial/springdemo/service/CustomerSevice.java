package com.tutorial.springdemo.service;

import java.util.List;

import com.tutorial.springdemo.entity.Customer;

public interface CustomerSevice {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

}
