package com.ncu.Spring_JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student std = new Student();
		std.setId(rs.getInt("student_id"));
		std.setName(rs.getString("student_name"));
		std.setAddress(rs.getString("student_address"));
		
		return std;
	}

}
