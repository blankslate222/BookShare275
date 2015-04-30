package edu.sjsu.cmpe275.bookshare.daoImpl;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.bookshare.dao.ListingDao;
import edu.sjsu.cmpe275.bookshare.model.Listing;

public class ListingDaoImpl implements ListingDao {

	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public int insert(Listing listing) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Listing getListingById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeListingById(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
