package com.bh.beauty.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bh.beauty.dao.MemberUserDao;
import com.bh.beauty.entity.MemberUser;

@RestController
public class HelloWorld {

	@Autowired
	private MemberUserDao userDao;

	@GetMapping("/hello")
	public String hello() {
		MemberUser m = new MemberUser();
		m.setName("张三");
		m.setPhoneNumber("178092100000");
		m.setMemberMeony(1000);
		m.setRemarks("正常充值");
		m.setMemberId(2);
		m.setMemberType("美发");
		m.setCreateDate(new Timestamp(System.currentTimeMillis()));
		return userDao.save(m) + "123";
	}
}
