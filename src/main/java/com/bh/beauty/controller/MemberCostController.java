package com.bh.beauty.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bh.beauty.dao.MemberCostDao;
import com.bh.beauty.dao.MemberUserDao;
import com.bh.beauty.entity.MemberCost;
import com.bh.beauty.entity.MemberUser;


@RestController
@RequestMapping("/api/membercost")
public class MemberCostController {
	
	@Autowired
	private MemberCostDao memberCostDao;

	@Autowired
	private MemberUserDao memberUserDao;
	
	@GetMapping("/findByMemberIdAndMemberType")
	public List<MemberCost> findMemberCost(@RequestParam int memberId, @RequestParam String memberType) {
		return memberCostDao.findByMemberIdAndMemberType(memberId, memberType);
	}
	
	@PostMapping("/save")
	@Transactional
	public MemberCost save(@RequestBody MemberCost memberCost) {
		
		MemberUser memberUser = memberUserDao.findByMemberIdAndMemberType(memberCost.getMemberId(), memberCost.getMemberType());

		memberUser.setPhoneNumber(memberCost.getPhoneNumber());
		memberUser.setMemberNumber(memberUser.getMemberNumber() - memberCost.getMemberNumber());
		memberUserDao.save(memberUser);
		
		memberCost.setPayDate(new Timestamp(System.currentTimeMillis()));
		
		return memberCostDao.save(memberCost);
	}
}
