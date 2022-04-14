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
	public void batchInsertRecords(List<Student> students) {
		int insertedRows = 0;
		String query = "insert into student values(?,?,?)";
		for (Student student : students) {
			
			Object[] args = {student.getId(), student.getName(), student.getAddress()};
			int row = jdbcTemplate.update(query, args);
			if(row==1) {
				System.out.println("Record added successfully");
				insertedRows++;
			}else {
				System.out.println("Insertion Failed!");
			}
		}
		
		if(insertedRows==students.size()) {
			System.out.println("All records inserted successfully");
		}
		else {
			System.out.println("Insertion failed  m  ");
		}
		
	};

	@Override
	public void batchUpdateRecords(List<Student> students) {
		// TODO Auto-generated method stub
		int insertedRows = 0;
		String query = "update student set student_name= ?, student_address= ? where student_id= ? ";
		for (Student student : students) {
			
			Object[] args = {student.getName(),student.getAddress(),student.getId()};
			int row = jdbcTemplate.update(query, args);
			if(row==1) {
				System.out.println("Record updated successfully");
				insertedRows++;
			}else {
				System.out.println("Failed to update!");
			}
		}
		
		if(insertedRows==students.size()) {
			System.out.println("All records updated successfully");
		}
		else {
			System.out.println("Failed to update");
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
		String query = "update student set student_name= ?, student_address= ? where student_id= ? ";
		Object[] args = {student.getName(), student.getAddress(), student.getId()};
		int row = jdbcTemplate.update(query, args);
		if(row==1) {
			System.out.println("Record updated successfully");
		}else {
			System.out.println("Updation Failed!");
		}
		

	}

	@Override
	public void deleteRecord(int id) {
		// TODO Auto-generated method stub
		String query = "delete from student where student_id= ?";
		int row = jdbcTemplate.update(query, id);
		if(row==1) {
			System.out.println("Record deleted successfully");
		}else {
			System.out.println("Deletion Failed!");
		}

	}
	
	@Override
	public void deleteAllRecord() {
		// TODO Auto-generated method stub
		String query = "delete from student";
		int row = jdbcTemplate.update(query);
		if(row==1) {
			System.out.println("Records deleted successfully");
		}else {
			System.out.println("Deletion Failed!");
		}

	}
	

}
