package org.ncu.finalProject.HealthCareManagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.ncu.finalProject.HealthCareManagement.entity.Customer;
import org.ncu.finalProject.HealthCareManagement.rowmapper.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Customer> loadCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customerList = new ArrayList();
		String query = "select * from customer";
		customerList = jdbcTemplate.query(query, new CustomerRowMapper());
		return customerList;
	}

	@Override
	public int createRecord(Customer customer) {
		// TODO Auto-generated method stub
		String query = "insert into customer values(?,?,?,?,?,?,?,?,?)";
		Object records[] = { customer.getCustomer_id(), customer.getCustomer_username(),
				customer.getCustomer_password(), customer.getCustomer_name(), customer.getCustomer_age(),
				customer.getCustomer_gender(), customer.getCustomer_contact(), customer.getCustomer_email(),
				customer.getCustomer_address() };
		int recordInserted = jdbcTemplate.update(query, records);
		return recordInserted;
	}

	@Override
	public int updateRecord(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "update customer set customer_username = ?, customer_password = ?, customer_name = ?, customer_age = ?, customer_gender = ?, customer_contact = ?, customer_email = ?, customer_address = ? where customer_id = ?";
		Object[] args = { customer.getCustomer_username(), customer.getCustomer_password(), customer.getCustomer_name(),
				customer.getCustomer_age(), customer.getCustomer_gender(), customer.getCustomer_contact(),
				customer.getCustomer_email(), customer.getCustomer_address(), customer.getCustomer_id(), };
		int recordsUpdated = jdbcTemplate.update(sql, args);
		return recordsUpdated;
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from customer where customer_id = ?";
		Customer customer = jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from customer where customer_id = ?";
		jdbcTemplate.update(sql, id);

	}

//	@SuppressWarnings("deprecation")
//	@Override
//	public boolean validateCustomer(String username, String password) {
//		// TODO Auto-generated method stub
//		String query = "select * from customer where customer_username=?";
//		Object[] args = { username };
//		List<Customer> ls = new ArrayList<Customer>();
//		ls = jdbcTemplate.query(query, args, new CustomerRowMapper());
//		ls.get(0).getCustomer_password();
//		if(ls.get(0).getCustomer_password().equals(password)) 
//		{
//			return true;
//		}
//		return false;
//	}

	@Override
	public boolean validateCustomer(String username, String password) {
		// TODO Auto-generated method stub
		String query = "select * from customer where customer_username='" + username + "' and customer_password='"
				+ password + "'";
		List<Customer> recordsFound = jdbcTemplate.query(query, new CustomerRowMapper());
		if(!recordsFound.isEmpty()) {
			return true;
		}
		return false;
	}

}
