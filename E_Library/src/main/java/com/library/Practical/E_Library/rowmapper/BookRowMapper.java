package com.library.Practical.E_Library.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library.Practical.E_Library.entity.Books;

public class BookRowMapper implements RowMapper<Books> {

	@Override
	public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Books book = new Books();
		book.setId(rs.getInt("id"));
		book.setTitle(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		book.setPrice(rs.getFloat("price"));
		book.setQty(rs.getInt("qty"));
		return book;
	}
	
}
