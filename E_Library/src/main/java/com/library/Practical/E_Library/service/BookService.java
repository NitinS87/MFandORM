package com.library.Practical.E_Library.service;

import java.util.List;

import com.library.Practical.E_Library.entity.Books;

public interface BookService {

	public List<Books> fetchBooks();
	
	public void saveBook(Books book);
	
	public void editBook(Books book);
	
	public Books getOneBook(int id);
	
	public void deleteOneBook(int id);
}
