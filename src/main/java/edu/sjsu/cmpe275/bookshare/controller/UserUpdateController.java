package edu.sjsu.cmpe275.bookshare.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.cmpe275.bookshare.dao.UserDao;
import edu.sjsu.cmpe275.bookshare.daoImpl.UserDaoImpl;
import edu.sjsu.cmpe275.bookshare.model.User;

@Controller
public class UserUpdateController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user,HttpServletRequest request) throws SQLException {
		HttpSession session = request.getSession();
		User updateUser = new User();
		updateUser.setFirstname(user.getFirstname());
		updateUser.setLastname(user.getLastname());
		updateUser.setAddress(user.getAddress());
		updateUser.setEmail("dummy@dummy.com");//dummy value(retreive email id from session variable and set as users email
		userDao.updateUserhbm(updateUser);//dummy value
		
		return new ModelAndView("redirect:/useraccount");
	}
	
	@RequestMapping(value="/updateuser")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("UpdateUser");
		model.addObject("user", new User());
		//model.addObject("user", new User());
		return model;		
	}
	
}