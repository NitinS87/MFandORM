package com.ncu.Spring_JDBC;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentDaoImpl implements StudentDAO {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertRecord(Student student) {
		// TODO Auto-generated method stub\
		String query = "insert into student values(?,?,?)";
		Object[] args = {student.getId(), student.getName(), student.getAddress()};
		int row = jdbcTemplate.update(query, args);
		if(row==1) {
			System.out.println("Record added successfully");
		}else {
			System.out.println("Insertion Failed!");
		}
		

	}

	@Override
	public List<Student> getAllRecords() {
		// TODO Auto-generated method stub
		String query = "select * from student";
		RowMapper<Student> rowMapper = new StudentRowMapper();
		List<Student> students = jdbcTemplate.query(query, rowMapper);
		return students;
		

	}

	@Override
	public void updateRecord(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRecord(int id) {
		// TODO Auto-generated method stub
		String query = "delete from student where student_id= ?";
		Object[] args = {id};
		int row = jdbcTemplate.update(query, args);
		if(row==1) {
			System.out.println("Record deleted successfully");
		}else {
			System.out.println("Deletion Failed!");
		}

	}

}
