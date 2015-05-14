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
				+ "(isbn,title,description,book_condition,price,author,book_status,user, isNegotiable) "
				+ " values(?,?,?,?,?,?,?,?,?)";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		//System.out.println(book.getIsbn()+"hello my name is anirudh");
		ps.setString(1, book.getIsbn());
		
		ps.setString(2, book.getTitle());
		ps.setString(3, book.getDescription());
		ps.setString(4, book.getCondition());
		ps.setString(5, book.getPrice());
		ps.setString(6, book.getAuthor());
		ps.setString(7, "available");
		ps.setString(8, book.getUser());
		ps.setString(9, book.getIsNegotiable());
		System.out.println("sql: "+sql);
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

	public List<Book> getAvailableBooks() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from book where book_status = 'available'";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		
		List<Book> bookList = new ArrayList<Book>();
		
		data = ps.executeQuery();
		while(data.next()){
		Book newBook = new Book();
		newBook.setId((data.getInt("id")));
		newBook.setIsbn((data.getString("isbn")));
		newBook.setTitle(data.getString("title"));
		newBook.setDescription(data.getString("description"));
		newBook.setCondition(data.getString("book_condition"));
		newBook.setPrice(data.getString("price"));
		newBook.setAuthor(data.getString("author"));
		newBook.setStatus(data.getString("book_status"));
		newBook.setUser((data.getString("user")));
		newBook.setIsNegotiable((data.getString("isNegotiable")));
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
	public Book getBookByIsbn(String isbn) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from book where isbn=? and book_status = 'available'";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(isbn));
		
		
		data = ps.executeQuery();
	
			Book newBook = new Book();
			if(data.next()){
			newBook.setId((data.getInt("id")));
			newBook.setIsbn((data.getString("isbn")));
			newBook.setTitle(data.getString("title"));
			newBook.setDescription(data.getString("description"));
			newBook.setCondition(data.getString("book_condition"));
			newBook.setPrice(data.getString("price"));
			newBook.setAuthor(data.getString("author"));
			newBook.setStatus(data.getString("book_status"));
			newBook.setUser((data.getString("user")));
			newBook.setIsNegotiable((data.getString("isNegotiable")));
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

		return newBook;
	}

	public Book getBookById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from book where id=? and book_status = 'available'";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, (id));
		System.out.println(" id = "+ id);
		
		data = ps.executeQuery();
	
			Book newBook = new Book();
			
			if(data.next()){
			newBook.setId((data.getInt("id")));
			newBook.setIsbn((data.getString("isbn")));
			newBook.setTitle(data.getString("title"));
			newBook.setDescription(data.getString("description"));
			newBook.setCondition(data.getString("book_condition"));
			newBook.setPrice(data.getString("price"));
			newBook.setAuthor(data.getString("author"));
			newBook.setStatus(data.getString("book_status"));
			newBook.setUser((data.getString("user")));
			newBook.setIsNegotiable((data.getString("isNegotiable")));
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

		return newBook;
	}

	public List<Book> getBookByTitle(String title) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from book where title like ? and book_status = 'available'";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + title + "%");
		List<Book> bookList = new ArrayList<Book>();
		
		data = ps.executeQuery();
		while(data.next()){
		Book newBook = new Book();
		newBook.setId((data.getInt("id")));
		newBook.setIsbn((data.getString("isbn")));
		newBook.setTitle(data.getString("title"));
		newBook.setDescription(data.getString("description"));
		newBook.setCondition(data.getString("book_condition"));
		newBook.setPrice(data.getString("price"));
		newBook.setAuthor(data.getString("author"));
		newBook.setStatus(data.getString("book_status"));
		newBook.setUser((data.getString("user")));
		newBook.setIsNegotiable((data.getString("isNegotiable")));
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
		String sql = "select * from book where author like ? and book_status = 'available'";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1,"%" + author + "%");
		
		
		data = ps.executeQuery();
		List<Book> bookList = new ArrayList<Book>();
		while(data.next())
		{
			Book newBook = new Book();
			newBook.setId((data.getInt("id")));
			newBook.setIsbn((data.getString("isbn")));
			newBook.setTitle(data.getString("title"));
			newBook.setDescription(data.getString("description"));
			newBook.setCondition(data.getString("book_condition"));
			newBook.setPrice(data.getString("price"));
			newBook.setAuthor(data.getString("author"));
			newBook.setStatus(data.getString("book_status"));
			newBook.setUser((data.getString("user")));
			newBook.setIsNegotiable((data.getString("isNegotiable")));
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
		String sql = "select * from book where user=? and book_status = 'available'";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, (user));
		
		
		data = ps.executeQuery();
		List<Book> bookList = new ArrayList<Book>();
		while(data.next())
		{
			Book newBook = new Book();
			newBook.setId((data.getInt("id")));
			newBook.setIsbn((data.getString("isbn")));
			newBook.setTitle(data.getString("title"));
			newBook.setDescription(data.getString("description"));
			newBook.setCondition(data.getString("book_condition"));
			newBook.setPrice(data.getString("price"));
			newBook.setAuthor(data.getString("author"));
			newBook.setStatus(data.getString("book_status"));
			newBook.setUser((data.getString("user")));
			newBook.setIsNegotiable((data.getString("isNegotiable")));
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
	
public void updateBookById(int id) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rowsAffected =0;
		String sql = "update book set book_status = 'sold' where id=?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		rowsAffected = ps.executeUpdate();
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return;
		
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
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return;
		
	}
	
	public void deleteBookByIsbn(String isbn) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rowsAffected =0;
		String sql = "delete from book where isbn=?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, isbn);
		
		
		rowsAffected = ps.executeUpdate();
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return;
		
	}

}
