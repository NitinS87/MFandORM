package com.library.Practical.E_Library.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.library.Practical.E_Library.entity.Books;
import com.library.Practical.E_Library.rowmapper.BookRowMapper;
@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Books> loadBooks() {
		// TODO Auto-generated method stub
		List<Books> booksList = new ArrayList();
		String query = "select * from books";
		booksList = jdbcTemplate.query(query, new BookRowMapper());
		return booksList;
	}

	@Override
	public int createRecord(Books book) {
		// TODO Auto-generated method stub
		String query = "insert into books values(?,?,?,?,?)";
		Object records[] = { book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getQty() };
		int recordInserted = jdbcTemplate.update(query, records);
		return recordInserted;
	}

	@Override
	public int updateRecord(Books book) {
		// TODO Auto-generated method stub
		String sql = "update books set title = ?, author = ?, price = ?, qty = ? where id = ?";
		Object[] args = { book.getTitle(), book.getAuthor(), book.getPrice(), book.getQty(), book.getId() };
		int recordsUpdated = jdbcTemplate.update(sql, args);
		return recordsUpdated;
	}

	@Override
	public Books getBook(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from books where id = ?";

		Books book = jdbcTemplate.queryForObject(sql, new BookRowMapper(), id);

		return book;
	}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from books where id = ?";
		jdbcTemplate.update(sql, id);
	}

}
