package com.ncu.Spring_JDBC;

import java.util.List;

public interface StudentDAO {
//Declare methods for CRUD operations

	// method for inserting a record into the database
	public void insertRecord(Student student);

	// method for retrieve a record into the database
	public List<Student> getAllRecords();

	// method for updating a record into the database
	public void updateRecord(Student student);

	// method for delete a record into the database
	public void deleteRecord(int id);
	
	//method for deleting all records from the database
	public void deleteAllRecord();
	
	//method for inserting a batch into database
	public void batchInsertRecords(List<Student> students);

	//method for updating a batch into database
	public void batchUpdateRecords(List<Student> students);

	

}
