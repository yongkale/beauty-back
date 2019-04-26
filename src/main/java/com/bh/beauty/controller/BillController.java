package com.bh.beauty.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bh.beauty.dao.CommmonUserDao;
import com.bh.beauty.dao.MemberRechageDao;
import com.bh.beauty.entity.MemberRechage;
import com.bh.beauty.util.TimeUtil;

@RestController
@RequestMapping("/api/bill")
public class BillController {
	public static final String START_DAY = "startday";
	public static final String END_DAY = "endday";

	@Autowired
	private CommmonUserDao commmonUserDao;
	
	@Autowired
	private MemberRechageDao memberRechageDao;
	
	@RequestMapping("/findCostMerber")
	public List<MemberRechage> findCostMerber(@RequestParam int memberId, @RequestParam String memberType ) {
		return memberRechageDao.findByMemberIdAndMemberType(memberId, memberType);
	}
	
	@RequestMapping("/findbill")
	public Object findCommoonUserBill(@RequestParam(required = false) Map<String, String> map) {
		TimeUtil.setStartTimeAndEndTime(map);
		return commmonUserDao.payDate(map.get(START_DAY) , map.get(END_DAY));
//				?commmonUserDao.payDate(new Date());
	}
	
	@RequestMapping("/findmemberbill")
	public Object findmemberbill(
//			@RequestParam(required = false) StringBuffer startday, @RequestParam(required = false) StringBuffer endday
			//为了实现引用传递，避免重复代码
			@RequestParam(required = false) Map<String, String> map
			) {
		TimeUtil.setStartTimeAndEndTime(map);
		
		return memberRechageDao.payDate(map.get(START_DAY) , map.get(END_DAY));
	}
}
