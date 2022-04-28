package com.library.Practical.E_Library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.Practical.E_Library.dao.BookDao;
import com.library.Practical.E_Library.entity.Books;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Books> fetchBooks() {
		// TODO Auto-generated method stub
		List<Books> bookList = bookDao.loadBooks();
		for(Books tempStudent : bookList) {
			System.out.println(tempStudent);
		}
		return bookList;
	}

	@Override
	public void saveBook(Books book) {
		// TODO Auto-generated method stub
		int rowAdded = bookDao.createRecord(book);
		if(rowAdded == 1) {
			System.out.println("Record saved successfully");
		}else {
			System.out.println("Error Occurred!!");
		}
	}

	@Override
	public void editBook(Books book) {
		// TODO Auto-generated method stub
		int rowUpdated = bookDao.updateRecord(book);
		if(rowUpdated == 1) {
			System.out.println("Record updated successfully");
		}else {
			System.out.println("Error Occurred!!");
		}
	}

	@Override
	public Books getOneBook(int id) {
		// TODO Auto-generated method stub
		Books book = bookDao.getBook(id);
		return book;
	}

	@Override
	public void deleteOneBook(int id) {
		// TODO Auto-generated method stub
		bookDao.deleteBook(id);
		System.out.println("Book with "+id+" is deleted successfully!!");
	}

	

}
