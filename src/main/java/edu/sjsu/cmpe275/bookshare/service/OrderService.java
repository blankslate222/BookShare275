package edu.sjsu.cmpe275.bookshare.service;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.bookshare.daoImpl.BidDaoImpl;
import edu.sjsu.cmpe275.bookshare.daoImpl.BookDaoImpl;
import edu.sjsu.cmpe275.bookshare.daoImpl.ListingDaoImpl;
import edu.sjsu.cmpe275.bookshare.daoImpl.OrderDaoImpl;
import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.model.Order;

@Service
public class OrderService {

	private OrderDaoImpl orderDaoImpl;
	private BookDaoImpl bookDaoImpl;
	private ListingDaoImpl listingDaoImpl;
	@Autowired
	private BidDaoImpl bidDaoImpl;

	public OrderDaoImpl getOrderDaoImpl() {
		return orderDaoImpl;
	}

	@Autowired
	public void setOrderDaoImpl(OrderDaoImpl orderDaoImpl) {
		this.orderDaoImpl = orderDaoImpl;
	}
	
	public BookDaoImpl getBookDaoImpl() {
		return bookDaoImpl;
	}

	@Autowired
	public void setBookDaoImpl(BookDaoImpl bookDaoImpl) {
		this.bookDaoImpl = bookDaoImpl;
	}

	public ListingDaoImpl getListingDaoImpl() {
		return listingDaoImpl;
	}

	@Autowired
	public void setListingDaoImpl(ListingDaoImpl listingDaoImpl) {
		this.listingDaoImpl = listingDaoImpl;
	}

	public Order getOrderById(int id) {
		Order order = null;
		try {
			order = getOrderDaoImpl().getOrderById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}
	public Order createOrder(Book book, String buyer) {
		Order generatedOrder = null;
		Order order = null;
		try {
			order = new Order();
			order.setBuyer(buyer);
			order.setIsbn(book.getIsbn());
			order.setSeller(book.getUser());
			order.setPrice(book.getPrice());
			order.setOrderDate(Calendar.getInstance());
			int orderedId = getOrderDaoImpl().insert(order);
			if(book.getIsNegotiable().toLowerCase().equals("yes")){
				bidDaoImpl.removeBidsByBookId(book.getId());
			}
			getBookDaoImpl().updateBookById(book.getId());
			generatedOrder = getOrderDaoImpl().getOrderById(orderedId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return generatedOrder;
		
	}
	
	//redirect to feedback screen in controller for all transactions
		public Order bookShare(String isbn, String buyer) {
			Book bookToBeShared = null;
			Order generatedOrder = null;
			try {
				bookToBeShared = getBookDaoImpl().getBookByIsbn(isbn);
				getListingDaoImpl().removeListingByIsbn(isbn);
				generatedOrder = createOrder(bookToBeShared, buyer);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return generatedOrder;
		}
		
		public void updateOrder(Order order) {
			try {
				orderDaoImpl.updateOrder(order);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public List<Order> getOrdersBySeller(String seller) {
			List<Order> orders = null;
			try {
				orders = getOrderDaoImpl().getOrderBySeller(seller);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return orders;
		}
		
		public List<Order> getOrdersByBuyer(String buyer) {
			List<Order> orders = null;
			try {
				orders = getOrderDaoImpl().getOrderByBuyer(buyer);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return orders;
		}

		
		public List<Order> getOrdersByIsbn(String isbn) {
			List<Order> orders = null;
			try {
				orders = getOrderDaoImpl().getOrdersByIsbn(isbn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return orders;
		}
}
