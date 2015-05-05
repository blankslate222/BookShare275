package edu.sjsu.cmpe275.bookshare.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.bookshare.daoImpl.UserDaoImpl;
import edu.sjsu.cmpe275.bookshare.model.User;

@Service
public class UserService {

	UserDaoImpl userDaoImpl = new UserDaoImpl();

	public UserDaoImpl getUserDaoImpl() {
		return userDaoImpl;
	}

	public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}
	
	public List<String> getUserNames() {
		List<String> userNames = new ArrayList<String>();
		List<User> users;
		try {
			users = userDaoImpl.getAllUsers();
			for(User u:users)
			{
				userNames.add(u.getFirstname()+" "+u.getLastname());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return(userNames);
		
		
	}
}
