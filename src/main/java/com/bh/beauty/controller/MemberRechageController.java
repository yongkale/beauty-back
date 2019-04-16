package com.bh.beauty.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bh.beauty.common.Constant;
import com.bh.beauty.dao.MemberRechageDao;
import com.bh.beauty.dao.MemberUserDao;
import com.bh.beauty.entity.MemberRechage;
import com.bh.beauty.entity.MemberUser;
import com.bh.beauty.util.TimeUtil;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;


@RestController
@RequestMapping("/api/rechage")
public class MemberRechageController {

	@Autowired
	private MemberUserDao memberUserDao;
	
	@Autowired
	private MemberRechageDao memberRechageDao;
	
	@GetMapping("/findAll")
	public List<MemberRechage> findAllcharge(@RequestParam(required = false) Map<String, String> map) {
//		 Sort sort = new Sort(Direction.DESC, "Create_date");
//		    PageRequest of = PageRequest.of(1,1,sort);
		TimeUtil.setStartTimeAndEndTime(map);
		return memberRechageDao.findAll(map.get(Constant.START_DAY) , map.get(Constant.END_DAY));
	}
	
	@PostMapping("/save")
	@Transactional
	public MemberRechage save(@RequestBody MemberRechage memberRechage) {
		
		MemberUser memberUser = memberUserDao.findByMemberIdAndMemberType(memberRechage.getMemberId(), memberRechage.getMemberType());

		memberUser.setPhoneNumber(memberRechage.getPhoneNumber());
		memberUser.setMemberNumber(memberUser.getMemberNumber() + memberRechage.getMemberNumber());
		
//		MemberRechage memberRechage = new MemberRechage();
//		memberRechage.setMemberMeony(memberUser.getMemberMeony());
//		memberRechage.setMemberNumber(memberUser.getMemberNumber());
//		memberRechage.setMemberType(memberUser.getMemberType());
//		memberRechage.setName(memberUser.getName());
		memberRechage.setPayDate(new Timestamp(System.currentTimeMillis()));
//		memberRechage.setPhoneNumber(memberUser.getPhoneNumber());
//		memberRechage.setRemarks(memberUser.getRemarks());
//		memberRechage.setRepsoenPerson(memberUser.getRepsoenPerson());
//		?memberRechage.setMemmberID(memberUser.getMemberId());

		
		memberUserDao.save(memberUser);

		return memberRechageDao.save(memberRechage);
	}
}
