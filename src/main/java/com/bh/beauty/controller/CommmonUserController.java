package com.bh.beauty.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bh.beauty.common.Constant;
import com.bh.beauty.dao.CommmonUserDao;
import com.bh.beauty.dao.CommomUserHistoryDao;
import com.bh.beauty.entity.CommomUserHistory;
import com.bh.beauty.entity.CommonUser;
import com.bh.beauty.util.TimeUtil;


@RestController
@RequestMapping("/api/commmonuser")
public class CommmonUserController {

	@Autowired
	private CommmonUserDao commmonUserDao;
	
	@Autowired
	private CommomUserHistoryDao commomUserHistoryDao;
	
	@PostMapping("/save")
	public CommonUser save(@ RequestBody CommonUser commmonUser, @RequestParam String type) {
		if ("update".equals(type)) {
			CommomUserHistory commomUserHistory = new CommomUserHistory();
			commomUserHistory.setCommonId(commmonUser.getCommonId());
			commomUserHistory.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			commomUserHistory.setRemainMoney(commmonUser.getPayMoney());
			commomUserHistoryDao.save(commomUserHistory);
		} else {
			commmonUser.setPayDate(new Timestamp(System.currentTimeMillis()));
		}
		return commmonUserDao.save(commmonUser);
	}
	
	@GetMapping("/findAll")
	public List<CommonUser> findAll(@RequestParam(required = false) Map<String, String> map) {
		TimeUtil.setStartTimeAndEndTime(map);
		return commmonUserDao.findAll(map.get(Constant.START_DAY) , map.get(Constant.END_DAY));
//		return commmonUserDao.findAll();
	}
}
