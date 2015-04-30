package edu.sjsu.cmpe275.bookshare.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

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

	public Bid getBidByListingId(int listingId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bid getBidByBidderEmail(String bidderEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeBidsByListingId(int listingId) {
		// TODO Auto-generated method stub
		
	}

}
