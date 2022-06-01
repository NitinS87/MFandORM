package org.ncu.finalProject.HealthCareManagement.dao;

import java.util.List;

import org.ncu.finalProject.HealthCareManagement.entity.Customer;

public interface CustomerDAO {

	// method for fetching all the customer records from the database
	public List<Customer> loadCustomers();

	// method for adding a record into the database
	public int createRecord(Customer customer);

	// method to update an existing record
	public int updateRecord(Customer customer);

	// method to fetch a single customer record
	public Customer getCustomer(int id);

	// method to delete a customer record from the database
	public void deleteCustomer(int id);
	
	//method to validate customer record from the database
	public boolean validateCustomer(String username,String password);

}
