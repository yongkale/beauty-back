package com.bh.beauty.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bh.beauty.dao.MemberRechageDao;
import com.bh.beauty.dao.MemberUserDao;
import com.bh.beauty.dao.MemberUserHistoyDao;
import com.bh.beauty.entity.MemberRechage;
import com.bh.beauty.entity.MemberUser;
import com.bh.beauty.entity.MemberUserHistoy;

@RestController
@RequestMapping("/api/member")
public class MemberController {

	@Autowired
	private MemberUserDao userDao;
	
	@Autowired
	private MemberRechageDao memberRechageDao;

	@Autowired
	private MemberUserHistoyDao memberUserHistoyDao;
	
	@GetMapping("/findMemberUserById")
	public MemberUser findMemberUserById(@RequestParam int id) {
		return userDao.findById(id);
	}
	
	@GetMapping("/findMemberUserBytypeAndId")
	public MemberUser findMemberUserBytypeAndId(@RequestParam int memberId, @RequestParam String memberType) {
		return userDao.findByMemberIdAndMemberType(memberId, memberType);
	}
	
//	@PostMapping("/rechage")
//	@Transactional
//	public MemberUser chearge(@RequestBody MemberUser memberUser) {
//		
//		MemberRechage memberRechage = new MemberRechage();
//		memberRechage.setMemberMeony(memberUser.getMemberMeony());
//		memberRechage.setMemberType(memberUser.getMemberType());
//		memberRechage.setName(memberUser.getName());
//		memberRechage.setPayDate(new Timestamp(System.currentTimeMillis()));
//		memberRechage.setPhoneNumber(memberUser.getPhoneNumber());
//		memberRechage.setRemarks(memberUser.getRemarks());
//		memberRechage.setRepsoenPerson(memberUser.getRepsoenPerson());
//		memberRechage.setMemberId(memberUser.getMemberId());
//
//		memberRechageDao.save(memberRechage);
//
//		memberUser.setRemarks(null);
//		memberUser.setRepsoenPerson(null);
//		return userDao.save(memberUser);
//	}

	@GetMapping("/findMemberUserHistoy")
	public List<MemberUserHistoy> findMemberUserHistoy(@RequestParam int idRef) {
		return memberUserHistoyDao.findByIdRef(idRef);
	}
	
	@PostMapping("/save")
	@Transactional
	public MemberUser save(@RequestBody MemberUser memberUser) {
		
		MemberUser memberUserFromDB = userDao.findByMemberIdAndMemberType(memberUser.getMemberId(), memberUser.getMemberType());
		
		if (null == memberUser.getCreateDate()) {
			memberUser.setCreateDate(new Timestamp(System.currentTimeMillis()));
			return userDao.save(memberUser);
		}
		
		MemberUserHistoy memberUserHistoy = new MemberUserHistoy();
		memberUserHistoy.setCreateDate(new Timestamp(System.currentTimeMillis()));
		memberUserHistoy.setMemberId(memberUser.getMemberId());
		memberUserHistoy.setMemberMeony(memberUser.getMemberMeony());
//		memberUserHistoy.setMemberType(memberType);
		memberUserHistoy.setName(memberUser.getName());
		memberUserHistoy.setPhoneNumber(memberUser.getPhoneNumber());
		memberUserHistoy.setRemarks(memberUser.getRemarks());
		memberUserHistoy.setRepsoenPerson(memberUser.getRepsoenPerson());
		memberUserHistoy.setIdRef(memberUser.getId());
		
		memberUserHistoyDao.save(memberUserHistoy);
		
		
		memberUserFromDB.setCreateDate(new Timestamp(System.currentTimeMillis()));
		memberUserFromDB.setMemberId(memberUser.getMemberId());
		memberUserFromDB.setMemberMeony(memberUser.getMemberMeony());
//		memberUserHistoy.setMemberType(memberType);
		memberUserFromDB.setName(memberUser.getName());
		memberUserFromDB.setPhoneNumber(memberUser.getPhoneNumber());
		return userDao.save(memberUserFromDB);
	}

	@GetMapping("/findByPhone")
	public MemberUser findByPhone(String phoneNumber) {
		return userDao.findByPhoneNumber(phoneNumber);
	}
	
	@PostMapping("/update")
	public MemberUser update(@RequestBody MemberUser memberUser) {
//		memberUser.setCreateDate(new Timestamp(System.currentTimeMillis()));
		return userDao.save(memberUser);
	}
	
	@GetMapping("/findAll")
	public List<MemberUser> findAll() {
//		Sort sort = new Sort(Direction.DESC, "createDate");
//	    PageRequest of = PageRequest.of(1,10,sort);
		return userDao.findAll();
	}
	
	@GetMapping("/search")
	public List<MemberUser> search(@RequestParam String searchKey) {
		return userDao.search("%"+ searchKey +"%");
	}
	
}
