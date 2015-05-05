package edu.sjsu.cmpe275.bookshare.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.bookshare.daoImpl.BookDaoImpl;
import edu.sjsu.cmpe275.bookshare.model.Book;

public class SearchService {
	private BookDaoImpl bookDaoImpl;

	public BookDaoImpl getBookDaoImpl() {
		return bookDaoImpl;
	}

	@Autowired
	public void setBookDaoImpl(BookDaoImpl bookDaoImpl) {
		this.bookDaoImpl = bookDaoImpl;
	}
	
	public List<Book> searchByTitle(String title){
		List<Book> books = null;
		try {
			 books = getBookDaoImpl().getBookByTitle(title);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
	
	public Book searchByIsbn(String isbn) {
		Book book = null;
		try {
			 book = getBookDaoImpl().getBookByIsbn(isbn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	
	public List<Book> searchByAuthor(String author) {
		List<Book> books = null;
		try {
			 books = getBookDaoImpl().getBookByAuthor(author);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
}
