package com.bh.beauty.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bh.beauty.common.Constant;
import com.bh.beauty.dao.CommmonUserDao;
import com.bh.beauty.dao.EmployeeDao;
import com.bh.beauty.dao.MemberCostDao;
import com.bh.beauty.util.TimeUtil;
import com.bh.beauty.vo.CountBillTypeCountVo;
import com.bh.beauty.vo.CountBillVo;


@RestController
@RequestMapping("/api/performance")
public class PperformanceController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private MemberCostDao memberCostDao;

	@Autowired
	private CommmonUserDao commmonUserDao;
	
	@RequestMapping("/membercountWork")
	public String membercountWork(@RequestParam(required = false) Map<String, String> map) {
		TimeUtil.setStartTimeAndEndTime(map);
		
		List<String> names = employeeDao.findAllName();
		List<CountBillVo> total = new ArrayList<CountBillVo>();
		for (int i = 0; i < names.size(); i++) {
			CountBillVo vo = new CountBillVo();
			vo.setProduct(names.get(i));
			List<Map<String, BigInteger>> findCountPeopleByType = memberCostDao.findCountPeopleByType(names.get(i), map.get(Constant.START_DAY) , map.get(Constant.END_DAY));

			for(Map<String, BigInteger> m : findCountPeopleByType) {
				if("美容".equals(m.get("type"))) {
					vo.setBeauty(m.get("count"));
				}
				
				if("美发".equals(m.get("type"))) {
					vo.setHair(m.get("count"));
				}
				
				if("美甲".equals(m.get("type"))) {
					vo.setNails(m.get("count"));
				}
			}
			
			total.add(vo);
		}
		
		return JSONObject.toJSONString(total).replaceAll("hair", "美发")
				.replaceAll("nails", "美甲")
				.replaceAll("beauty", "美容");
	}
	
	@RequestMapping("/countWork")
	public String countWork(@RequestParam(required = false) Map<String, String> map) {
		TimeUtil.setStartTimeAndEndTime(map);
		
		List<String> names = employeeDao.findAllName();
		List<CountBillVo> total = new ArrayList<CountBillVo>();
		for (int i = 0; i < names.size(); i++) {
			CountBillVo vo = new CountBillVo();
			vo.setProduct(names.get(i));
			List<Map<String, BigInteger>> findCountPeopleByType = commmonUserDao.findCountPeopleByType(names.get(i), map.get(Constant.START_DAY) , map.get(Constant.END_DAY));

			for(Map<String, BigInteger> m : findCountPeopleByType) {
				if("美容".equals(m.get("type"))) {
					vo.setBeauty(m.get("count"));
				}
				
				if("美发".equals(m.get("type"))) {
					vo.setHair(m.get("count"));
				}
				
				if("美甲".equals(m.get("type"))) {
					vo.setNails(m.get("count"));
				}
			}
			
			total.add(vo);
		}
		
		return JSONObject.toJSONString(total).replaceAll("hair", "美发")
				.replaceAll("nails", "美甲")
				.replaceAll("beauty", "美容");
	}	
}
