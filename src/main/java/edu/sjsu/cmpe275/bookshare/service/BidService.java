package edu.sjsu.cmpe275.bookshare.service;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import edu.sjsu.cmpe275.bookshare.daoImpl.BidDaoImpl;
import edu.sjsu.cmpe275.bookshare.daoImpl.BookDaoImpl;
import edu.sjsu.cmpe275.bookshare.model.Bid;
import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class BidService {

	private BidDaoImpl bidDaoImpl;
	
	@Autowired
	private BookDaoImpl bookDaoImpl;

	@Autowired
	private OrderService orderService;
	
	public BidDaoImpl getBidDaoImpl() {
		return bidDaoImpl;
	}

	@Autowired
	public void setBidDaoImpl(BidDaoImpl bidDaoImpl) {
		this.bidDaoImpl = bidDaoImpl;
	}

	public int makeOffer(Book book, String newOffer, String bidderEmail) {
		Bid bid = new Bid();
		int retVal = 0;
		try {
			if(book.getIsNegotiable().equals("yes")){
				bid.setBidderEmail(bidderEmail);
				bid.setBookId(book.getId());
				bid.setOfferPrice(newOffer);
				bid.setBidTime(Calendar.getInstance());
				bid.setSeller(book.getUser());
				getBidDaoImpl().insert(bid);
				retVal = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		return retVal;
	}
	
	public void acceptOffer(Bid bid) {
		Book book = null;
		Order order = null;
		try {
			book = bookDaoImpl.getBookById(bid.getBookId());
			order = orderService.createOrder(book, bid.getBidderEmail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Bid> getBid(String seller) {
		List<Bid> bid = null;
		try {
			bid = getBidDaoImpl().getBidBySeller(seller);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bid;
	}
	
}
