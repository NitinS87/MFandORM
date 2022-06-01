package org.ncu.finalProject.HealthCareManagement.service;

import java.util.List;

import org.ncu.finalProject.HealthCareManagement.dao.CustomerDAO;
import org.ncu.finalProject.HealthCareManagement.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;

	@Override
	public List<Customer> fetchCustomer() {
		// TODO Auto-generated method stub
		List<Customer> customerList = customerDao.loadCustomers();
		for (Customer tempCustomer : customerList) {
			System.out.println(tempCustomer);
		}
		return customerList;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		int rowAdded = customerDao.createRecord(customer);
		if (rowAdded == 1) {
			System.out.println("Record saved successfully");
		} else {
			System.out.println("Error Occurred!!");
		}

	}

	@Override
	public void editCustomer(Customer customer) {
		// TODO Auto-generated method stub
		int rowUpdated = customerDao.updateRecord(customer);
		if (rowUpdated == 1) {
			System.out.println("Record updated successfully");
		} else {
			System.out.println("Error Occurred!!");
		}

	}

	@Override
	public Customer getOneCustomer(int id) {
		// TODO Auto-generated method stub
		Customer customer = customerDao.getCustomer(id);
		return customer;
	}

	@Override
	public void deleteOneCustomer(int id) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(id);
		System.out.println("Customer with " + id + " is deleted successfully!!");

	}

	@Override
	public boolean validateCustomer(String username, String pass) {
		// TODO Auto-generated method stub
		if((customerDao.validateCustomer(username, pass)) == true) {
			return true;
		};
		return false;
	}

}
