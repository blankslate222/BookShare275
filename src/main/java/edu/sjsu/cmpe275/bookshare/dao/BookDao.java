package edu.sjsu.cmpe275.bookshare.dao;

import java.sql.SQLException;

import edu.sjsu.cmpe275.bookshare.model.Book;

public interface BookDao {

	public int insert(Book book) throws SQLException;

	// to provide search facility
	public Book getBookByIsbn(String isbn) throws SQLException;

	// to provide search facility
	public Book getBookByTitle(String title) throws SQLException;

	// to provide search facility
	public Book getBookByAuthor(String author) throws SQLException;

	// useful to fetch book for user home page
	// and search facility
	public Book getBookByUser(String user) throws SQLException;

}
