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
import com.bh.beauty.common.Result;
import com.bh.beauty.dao.MemberCostDao;
import com.bh.beauty.dao.MemberUserDao;
import com.bh.beauty.entity.MemberCost;
import com.bh.beauty.entity.MemberUser;
import com.bh.beauty.util.TimeUtil;


@RestController
@RequestMapping("/api/membercost")
public class MemberCostController {
	
	@Autowired
	private MemberCostDao memberCostDao;

	@Autowired
	private MemberUserDao memberUserDao;

	@GetMapping("/peploeName")
	public List<MemberCost> findByMemberId(@RequestParam String peploeName, @RequestParam(required = false) Map<String, String> map) {
		TimeUtil.setStartTimeAndEndTime(map);
		return memberCostDao.findByPople(peploeName, map.get(Constant.START_DAY) , map.get(Constant.END_DAY));
	}
	
	@GetMapping("/findMemberType")
	public List<MemberCost> findMemberByType(@RequestParam String memberType, @RequestParam(required = false) Map<String, String> map) {
		TimeUtil.setStartTimeAndEndTime(map);
		return memberCostDao.findByMemberType(memberType,map.get(Constant.START_DAY) , map.get(Constant.END_DAY));
	}
	
	@GetMapping("/findByMemberIdAndMemberType")
	public List<MemberCost> findMemberCost(@RequestParam int memberId, @RequestParam String memberType) {
		return memberCostDao.findByMemberIdAndMemberType(memberId, memberType);
	}
	
	@PostMapping("/save")
	@Transactional
	public Result<Object> save(@RequestBody MemberCost memberCost) {
		Result<Object> result = new Result<Object>();
		
		MemberUser memberUser = memberUserDao.findByMemberIdAndMemberType(memberCost.getMemberId(), memberCost.getMemberType());

		memberUser.setPhoneNumber(memberCost.getPhoneNumber());
		int leftMoney = memberUser.getMemberMeony() - memberCost.getCostMoney();

		if (leftMoney < 0) {
			result.setStatus(Result.ERROR);
			result.setMsg("余额不足,请充值。。。");
			return result;
		}

		memberUser.setMemberMeony(leftMoney);
		memberUserDao.save(memberUser);
		
		memberCost.setPayDate(new Timestamp(System.currentTimeMillis()));
		result.setStatus(Result.SUCCESS);
		result.setData(memberCostDao.save(memberCost));
		return result;
	}
}
