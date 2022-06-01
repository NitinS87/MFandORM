package org.ncu.finalProject.HealthCareManagement.service;

import java.util.List;

import org.ncu.finalProject.HealthCareManagement.entity.Customer;

public interface CustomerService {
	
	public List<Customer> fetchCustomer();
	
	public void saveCustomer(Customer customer);
	
	public void editCustomer(Customer customer);
	
	public Customer getOneCustomer(int id);
	
	public void deleteOneCustomer(int id);

	public boolean validateCustomer(String username, String pass);

} 
