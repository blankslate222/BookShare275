package edu.sjsu.cmpe275.bookshare.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	//@Autowired
	//private UserDaoImpl userDaoImpl;

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user, Model model,
			HttpServletRequest request) throws SQLException {
		
		User updateUser = new User();
		updateUser.setFirstname(user.getFirstname());
		updateUser.setLastname(user.getLastname());
		updateUser.setAddress(user.getAddress());
		updateUser.setEmail(""+request.getSession().getAttribute("user"));// dummy value(retreive email id
												// from session variable and set
												// as users email
		userDao.updateUserhbm(updateUser);// dummy value

		return new ModelAndView("redirect:/useraccount");
	}

	@RequestMapping(value = "/updateuser")
	public ModelAndView login(Model model, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("UpdateUser");
		try {
			mv.addObject(
					"user",
					userDao.getUserByEmail(""
							+ req.getSession().getAttribute("user")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// model.addObject("user", new User());
		return mv;
	}

}