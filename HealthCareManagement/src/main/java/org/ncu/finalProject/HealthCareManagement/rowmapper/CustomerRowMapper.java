package org.ncu.finalProject.HealthCareManagement.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ncu.finalProject.HealthCareManagement.entity.Customer;
import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setCustomer_id(rs.getInt("customer_id"));
		customer.setCustomer_username(rs.getString("customer_username"));
		customer.setCustomer_password(rs.getString("customer_password"));
		customer.setCustomer_name(rs.getString("customer_name"));
		customer.setCustomer_age(rs.getInt("customer_age"));
		customer.setCustomer_gender(rs.getString("customer_gender"));
		customer.setCustomer_contact(rs.getString("customer_contact"));
		customer.setCustomer_email(rs.getString("customer_email"));
		customer.setCustomer_address(rs.getString("customer_address"));
		return customer;
	}

	
}
