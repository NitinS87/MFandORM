package com.library.Practical.E_Library.dao;

import java.util.List;

import com.library.Practical.E_Library.entity.Books;

public interface BookDao {

	// method for fetching all the student records from the database
	public List<Books> loadBooks();

	// method for adding a record into the database
	public int createRecord(Books book);

	// method to update an existing record
	public int updateRecord(Books book);

	// method to fetch a single student record
	public Books getBook(int id);

	// method to delete a student record from the database
	public void deleteBook(int id);

}
