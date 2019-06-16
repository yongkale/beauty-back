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
import com.bh.beauty.entity.CommonUser;
import com.bh.beauty.util.TimeUtil;


@RestController
@RequestMapping("/api/commmonuser")
public class CommmonUserController {

	@Autowired
	private CommmonUserDao commmonUserDao;

	@GetMapping("/findMoneyByType")
	public List<Map<String, Long>>  findMoneyByType (@RequestParam(required = false) Map<String, String> map) {
		TimeUtil.setStartTimeAndEndTime(map);
		return commmonUserDao.findMoneyByType(map.get(Constant.START_DAY) , map.get(Constant.END_DAY));
	}
	
	@GetMapping("/findCountByType")
	public List<Map<String, Long>>  findCountByType (@RequestParam(required = false) Map<String, String> map) {
		TimeUtil.setStartTimeAndEndTime(map);
		return commmonUserDao.findByType(map.get(Constant.START_DAY) , map.get(Constant.END_DAY));
	}
	
	@GetMapping("/findByType")
	public List<CommonUser> findByType(@RequestParam String type, @RequestParam(required = false) Map<String, String> map) {
		TimeUtil.setStartTimeAndEndTime(map);
		return commmonUserDao.findByType(type, map.get(Constant.START_DAY) , map.get(Constant.END_DAY));
	}
	
	@GetMapping("/peploeName")
	public List<CommonUser> findByPeploeName(@RequestParam String peploeName, @RequestParam(required = false) Map<String, String> map) {
		TimeUtil.setStartTimeAndEndTime(map);
		return commmonUserDao.findByPeploeName(peploeName, map.get(Constant.START_DAY) , map.get(Constant.END_DAY));
	}
	
	@PostMapping("/save")
	public CommonUser save(@ RequestBody CommonUser commmonUser, @RequestParam String type) {
		commmonUser.setPayDate(new Timestamp(System.currentTimeMillis()));
		return commmonUserDao.save(commmonUser);
	}
	
	@GetMapping("/findAll")
	public List<CommonUser> findAll(@RequestParam(required = false) Map<String, String> map) {
		TimeUtil.setStartTimeAndEndTime(map);
		return commmonUserDao.findAll(map.get(Constant.START_DAY) , map.get(Constant.END_DAY));
//		return commmonUserDao.findAll();
	}
}
