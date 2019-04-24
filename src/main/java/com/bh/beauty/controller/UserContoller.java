package com.bh.beauty.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bh.beauty.common.Constant;
import com.bh.beauty.dao.UserDao;
import com.bh.beauty.entity.User;

@RestController
//@RequestMapping("/api/user")
public class UserContoller {

	@Autowired
	private UserDao userDao;
	
//	@PostMapping("register")
	public User register(User user) {
		return userDao.save(user);
	}
	
	@GetMapping("/api/logout")
	public void logout(HttpServletRequest request) {
		request.getSession().invalidate();
	}
	
	@PostMapping("/api/user/login")
	public User findByUserName(@RequestBody User user, HttpServletRequest request) {
		User userFromDB = userDao.findByUserName(user.getUserName());
		if (null != userFromDB && userFromDB.getPassword().equals(user.getPassword())) {
			userFromDB.setPassword(null);
			request.getSession().setAttribute(Constant.USER_NAME,1);
		} else {
			userFromDB = null;
		}

		return userFromDB;
	}
}
