package edu.sjsu.cmpe275.bookshare.service;

import edu.sjsu.cmpe275.bookshare.daoImpl.BidDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidService {

	private BidDaoImpl bidDaoImpl;

	public BidDaoImpl getBidDaoImpl() {
		return bidDaoImpl;
	}

	@Autowired
	public void setBidDaoImpl(BidDaoImpl bidDaoImpl) {
		this.bidDaoImpl = bidDaoImpl;
	}
	
}
