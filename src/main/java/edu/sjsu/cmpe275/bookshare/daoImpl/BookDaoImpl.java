package edu.sjsu.cmpe275.bookshare.daoImpl;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.bookshare.dao.BookDao;
import edu.sjsu.cmpe275.bookshare.model.Book;

public class BookDaoImpl implements BookDao {

	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int insert(Book book) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Book getBookByIsbn(String isbn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Book getBookByTitle(String title) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Book getBookByAuthor(String author) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Book getBookByUser(String user) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
