package edu.sjsu.cmpe275.bookshare.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.bookshare.daoImpl.BookDaoImpl;

@Service
public class BookService {

	private BookDaoImpl bookDaoImpl;

	public BookDaoImpl getBookDaoImpl() {
		return bookDaoImpl;
	}

	@Autowired
	public void setBookDaoImpl(BookDaoImpl bookDaoImpl) {
		this.bookDaoImpl = bookDaoImpl;
	}
	
}
