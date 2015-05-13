package edu.sjsu.cmpe275.bookshare.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Convert;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.bookshare.dao.BidDao;
import edu.sjsu.cmpe275.bookshare.model.Bid;

public class BidDaoImpl implements BidDao{

	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public int insert(Bid bid) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		int insert = 0;

		String sql = "insert into bidDetails"
				+ "(bookId, bidderEmail, offerPrice, bidTime, seller) "
				+ " values(?,?,?,?, ?)";
System.out.println(sql);
		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, bid.getBookId());
		ps.setString(2, bid.getBidderEmail());
		ps.setString(3, bid.getOfferPrice());
		ps.setTimestamp(4, new Timestamp(bid.getBidTime().getTimeInMillis()));
		ps.setString(5, bid.getSeller());
		
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

	public List<Bid> getBidByBookId(int bookId) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from bidDetails where bookId=?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, bookId);
		
		
		data = ps.executeQuery();
		List<Bid> bidList = new ArrayList<Bid>();
		Calendar c = Calendar.getInstance();
		while(data.next())
		{
			Bid newBook = new Bid();
			newBook.setBidderEmail(data.getString("bidderEmail"));
			c.setTime(data.getDate("bidTime"));
			newBook.setBidTime(c);
			newBook.setId(data.getInt("id"));
			newBook.setBookId(data.getInt("bookId"));
			newBook.setOfferPrice(data.getString("offerPrice"));
			newBook.setSeller(data.getString("seller"));
			bidList.add(newBook);
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

		return (bidList);
//		return null;
	}

	public Bid getBidByBidderEmail(String bidderEmail) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from bidDetails where bidderEmail=?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, bidderEmail);
		
		
		data = ps.executeQuery();
		Bid bidData = new Bid();
		Calendar c = Calendar.getInstance();
		if(data.next()){
		bidData.setBidderEmail(data.getString("bidderEmail"));
		c.setTime(data.getDate("bidTime"));
		bidData.setBidTime(c);
		bidData.setId(data.getInt("id"));
		bidData.setBookId(data.getInt("bookId"));
		bidData.setOfferPrice(data.getString("offerPrice"));
		bidData.setSeller(data.getString("seller"));
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

		return (bidData);

//		return null;
	}

	public Bid getBidByBidId(int bidId) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from bidDetails where id=?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, bidId);
		
		
		data = ps.executeQuery();
		Bid bidData = new Bid();
		Calendar c = Calendar.getInstance();
		
		if(data.next()){
		bidData.setBidderEmail(data.getString("bidderEmail"));
		c.setTime(data.getDate("bidTime"));
		bidData.setBidTime(c);
		bidData.setId(data.getInt("id"));
		bidData.setBookId(data.getInt("bookId"));
		bidData.setOfferPrice(data.getString("offerPrice"));
		bidData.setSeller(data.getString("seller"));
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

		return (bidData);

//		return null;
	}
	public void removeBidsByBookId(int bookId) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from bidDetails where bookId = " + bookId;

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		//ps.setInt(1, bookId);
		System.out.println(sql + bookId);
	
		ps.executeUpdate(sql);
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Bid> getBidBySeller(String seller) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from bidDetails where seller=?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, seller);
		
		
		data = ps.executeQuery();
		List<Bid> bidList = new ArrayList<Bid>();
		Calendar c = Calendar.getInstance();
		while(data.next())
		{
			Bid newBook = new Bid();
			newBook.setBidderEmail(data.getString("bidderEmail"));
			c.setTime(data.getDate("bidTime"));
			newBook.setBidTime(c);
			newBook.setId(data.getInt("id"));
			newBook.setBookId(data.getInt("bookId"));
			newBook.setOfferPrice(data.getString("offerPrice"));
			newBook.setSeller(data.getString("seller"));
			bidList.add(newBook);
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

		return (bidList);
	}

	public List<Bid> getBidByListingId(int listingId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
