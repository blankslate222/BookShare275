package edu.sjsu.cmpe275.bookshare.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	private boolean isAuthorized(String user) {
		String userInSession = user;
		
		if("".equals(userInSession) || "Guest".equals(userInSession)){
			return false;
		}
		
		return true;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user, Model model,
			HttpServletRequest request, HttpServletResponse res) {
		
		User updateUser = new User();
		updateUser.setFirstname(user.getFirstname());
		updateUser.setLastname(user.getLastname());
		updateUser.setAddress(user.getAddress());
		updateUser.setEmail(""+request.getSession().getAttribute("user"));
		
		if(!isAuthorized((String)request.getSession().getAttribute("user"))) {
			return new ModelAndView("redirect:/login");
		}
		
		try {
			userDao.updateUserhbm(updateUser);
			res.setStatus(201);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.setStatus(400);
		}// dummy value

		return new ModelAndView("redirect:/useraccount");
	}

	@RequestMapping(value = "/updateuser")
	public ModelAndView login(Model model, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView("UpdateUser");
		if(!isAuthorized((String)req.getSession().getAttribute("user"))) {
			return new ModelAndView("redirect:/login");
		}
		try {
			mv.addObject(
					"user",
					userDao.getUserByEmail(""
							+ req.getSession().getAttribute("user")));
			res.setStatus(200);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.setStatus(404);
		}
		// model.addObject("user", new User());
		return mv;
	}

}