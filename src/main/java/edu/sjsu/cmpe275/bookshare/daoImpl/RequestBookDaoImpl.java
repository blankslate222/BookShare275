package edu.sjsu.cmpe275.bookshare.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.bookshare.model.Book;

public class RequestBookDaoImpl {
	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public int createBookRequest(Book book) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int insert = 0;

		String sql = "insert into requestBook"
				+ "(isbn,title,description,book_condition,price,author,requestingUser) "
				+ " values(?,?,?,?,?,?,?)";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		//System.out.println(book.getIsbn()+"hello my name is anirudh");
		ps.setString(1, book.getIsbn());
		
		ps.setString(2, book.getTitle());
		ps.setString(3, book.getDescription());
		ps.setString(4, book.getCondition());
		ps.setString(5, book.getPrice());
		ps.setString(6, book.getAuthor());
		ps.setString(7, book.getUser());
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
	
	public void deleteBookRequestById(int id) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rowsAffected =0;
		String sql = "delete from requestBook where id=?";

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
	
	public List<Book> getRequests() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from requestBook";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		
		List<Book> reqList = new ArrayList<Book>();
		
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
		newBook.setUser(data.getString("requestingUser"));
		reqList.add(newBook);
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

		return reqList;
	}
	
	public Book getRequestedBookByRequestId(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		Book newBook = null;
		String sql = "select * from requestBook where id = ?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		data = ps.executeQuery();
		if(data.next()){
		newBook = new Book();
		newBook.setId((data.getInt("id")));
		newBook.setIsbn((data.getString("isbn")));
		newBook.setTitle(data.getString("title"));
		newBook.setDescription(data.getString("description"));
		newBook.setCondition(data.getString("book_condition"));
		newBook.setPrice(data.getString("price"));
		newBook.setAuthor(data.getString("author"));
		newBook.setUser(data.getString("requestingUser"));
		
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
}
