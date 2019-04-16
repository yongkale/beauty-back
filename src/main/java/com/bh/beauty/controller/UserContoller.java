package com.bh.beauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/api/user/login")
	public User findByUserName(@RequestBody User user) {
		User userFromDB = userDao.findByUserName(user.getUserName());
		if (null != userFromDB && userFromDB.getPassword().equals(user.getPassword())) {
			userFromDB.setPassword(null);
		} else {
			userFromDB = null;
		}

		return userFromDB;
	}
}
