package edu.sjsu.cmpe275.bookshare.dao;

import java.sql.SQLException;
import java.util.List;

import edu.sjsu.cmpe275.bookshare.model.Book;

public interface BookDao {

	public int insert(Book book) throws SQLException;

	// to provide search facility
	public Book getBookByIsbn(String isbn) throws SQLException;

	// to provide search facility
	public List<Book> getBookByTitle(String title) throws SQLException;

	// to provide search facility
	public List<Book> getBookByAuthor(String author) throws SQLException;

	// useful to fetch book for user home page
	// and search facility
	public List<Book> getBookByUser(String user) throws SQLException;
	// added delete to remove book if not required or runs out-(anirudh)
	public void deleteBookById(int id) throws SQLException;

}
