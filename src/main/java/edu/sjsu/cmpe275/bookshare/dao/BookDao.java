package edu.sjsu.cmpe275.bookshare.dao;

import edu.sjsu.cmpe275.bookshare.model.Book;

public interface BookDao {

	public int insert();

	// to provide search facility
	public Book getBookByIsbn(String isbn);

	// to provide search facility
	public Book getBookByTitle(String title);

	// to provide search facility
	public Book getBookByAuthor(String author);

	// useful to fetch book for user home page
	// and search facility
	public Book getBookByUser(String user);

}
