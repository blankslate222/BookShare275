package edu.sjsu.cmpe275.bookshare.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.bookshare.dao.BookDao;
import edu.sjsu.cmpe275.bookshare.model.Bid;
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
		Connection conn = null;
		PreparedStatement ps = null;
		int insert = 0;

		String sql = "insert into book"
				+ "(isbn,title,description,condition,price,author,status) "
				+ "values(?,?,?,?,?,?,?);";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		System.out.println(book.getIsbn()+"hello my name is anirudh");
		ps.setInt(1, Integer.parseInt(book.getIsbn().toString()));
		
		ps.setString(2, book.getTitle());
		ps.setString(3, book.getDescription());
		ps.setString(4, book.getCondition());
		ps.setString(5, book.getPrice());
		ps.setString(6, book.getAuthor());
		ps.setString(7, book.getStatus());
		//ps.setInt(8, Integer.parseInt(book.getUser().toString()));
		
		insert = ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		int rowid = 0;
		if (rs.next()) {
			System.out.println(rs.toString());
			rowid = rs.getInt(1);
		}
		try {
			ps.close();
			conn.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (rowid);
	}

	
	public Book getBookByIsbn(String isbn) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from book where isbn=?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(isbn));
		
		
		data = ps.executeQuery();
	
			Book newBook = new Book();
			newBook.setIsbn(Integer.toString(data.getInt("isbn")));
			newBook.setTitle(data.getString("title"));
			newBook.setDescription(data.getString("description"));
			newBook.setCondition(data.getString("condition"));
			newBook.setPrice(data.getString("price"));
			newBook.setAuthor(data.getString("author"));
			newBook.setStatus(data.getString("status"));
			newBook.setUser(Integer.toString(data.getInt("user")));
		
		/*int rowid = 0;
		if (rs.next()) {
			System.out.println(rs.toString());
			rowid = rs.getInt(1);
		}*/
		try {
			ps.close();
			conn.close();
			data.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return newBook;
	}

	
	public List<Book> getBookByTitle(String title) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from book where title like ?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + title + "%");
		List<Book> bookList = new ArrayList<Book>();
		
		data = ps.executeQuery();
		while(data.next()){
		Book newBook = new Book();
		newBook.setIsbn(Integer.toString(data.getInt("isbn")));
		newBook.setTitle(data.getString("title"));
		newBook.setDescription(data.getString("description"));
		newBook.setCondition(data.getString("condition"));
		newBook.setPrice(data.getString("price"));
		newBook.setAuthor(data.getString("author"));
		newBook.setStatus(data.getString("status"));
		newBook.setUser(Integer.toString(data.getInt("user")));
		bookList.add(newBook);
		}
		/*int rowid = 0;
		if (rs.next()) {
			System.out.println(rs.toString());
			rowid = rs.getInt(1);
		}*/
		try {
			ps.close();
			conn.close();
			data.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookList;
	}

	
	public List<Book> getBookByAuthor(String author) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from book where author like ?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1,"%" + author + "%");
		
		
		data = ps.executeQuery();
		List<Book> bookList = new ArrayList<Book>();
		while(data.next())
		{
			Book newBook = new Book();
			newBook.setIsbn(Integer.toString(data.getInt("isbn")));
			newBook.setTitle(data.getString("title"));
			newBook.setDescription(data.getString("description"));
			newBook.setCondition(data.getString("condition"));
			newBook.setPrice(data.getString("price"));
			newBook.setAuthor(data.getString("author"));
			newBook.setStatus(data.getString("status"));
			newBook.setUser(Integer.toString(data.getInt("user")));
			bookList.add(newBook);
		}
		
		/*int rowid = 0;
		if (rs.next()) {
			System.out.println(rs.toString());
			rowid = rs.getInt(1);
		}*/
		try {
			ps.close();
			conn.close();
			data.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookList;
	}

	
	public List<Book> getBookByUser(String user) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from book where user=?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(user));
		
		
		data = ps.executeQuery();
		List<Book> bookList = new ArrayList<Book>();
		while(data.next())
		{
			Book newBook = new Book();
			newBook.setIsbn(Integer.toString(data.getInt("isbn")));
			newBook.setTitle(data.getString("title"));
			newBook.setDescription(data.getString("description"));
			newBook.setCondition(data.getString("condition"));
			newBook.setPrice(data.getString("price"));
			newBook.setAuthor(data.getString("author"));
			newBook.setStatus(data.getString("status"));
			newBook.setUser(Integer.toString(data.getInt("user")));
			bookList.add(newBook);
		}
		
		/*int rowid = 0;
		if (rs.next()) {
			System.out.println(rs.toString());
			rowid = rs.getInt(1);
		}*/
		try {
			ps.close();
			conn.close();
			data.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookList;
	}
	
	public void deleteBookById(int id) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rowsAffected =0;
		String sql = "delete from book where id=?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		
		rowsAffected = ps.executeUpdate();
		
		
		return;
		
	}
	
}
