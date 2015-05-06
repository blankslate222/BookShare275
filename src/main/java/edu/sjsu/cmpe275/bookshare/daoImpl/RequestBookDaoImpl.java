package edu.sjsu.cmpe275.bookshare.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
