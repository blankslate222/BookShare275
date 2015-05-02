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
				+ "(listingId, bidderEmail, offerPrice, bidTime) "
				+ " values(?,?,?,?)";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, bid.getListingId());
		ps.setString(2, bid.getBidderEmail());
		ps.setString(3, bid.getOfferPrice());
		ps.setTimestamp(4, new Timestamp(bid.getBidTime().getTimeInMillis()));
		
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

	public List<Bid> getBidByListingId(int listingId) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from bidDetails where listingId=?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, listingId);
		
		
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
			newBook.setListingId(data.getInt("listingId"));
			newBook.setOfferPrice(data.getString("offerPrice"));
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
		bidData.setBidderEmail(data.getString("bidderEmail"));
		c.setTime(data.getDate("bidTime"));
		bidData.setBidTime(c);
		bidData.setId(data.getInt("id"));
		bidData.setListingId(data.getInt("listingId"));
		bidData.setOfferPrice(data.getString("offerPrice"));
		
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

	public void removeBidsByListingId(int listingId) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE from bidDetails where bidderEmail=?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, listingId);
		ps.executeUpdate(sql);
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
