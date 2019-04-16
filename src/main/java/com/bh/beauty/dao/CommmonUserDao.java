package com.bh.beauty.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.bh.beauty.entity.CommonUser;
import com.bh.beauty.entity.MemberRechage;

public interface CommmonUserDao  extends JpaRepository<CommonUser, Long>, JpaSpecificationExecutor<CommonUser>,Serializable {

	@Query(value="SELECT sum(pay_money) FROM commonuser where DATE_FORMAT(Pay_Date,'%Y%m%d') BETWEEN :startday and :endday", nativeQuery = true)
	public Object payDate(String startday ,String endday);

//	@Query(value="SELECT sum(pay_money) FROM commonuser where DATE_FORMAT(Pay_Date,'%Y%m%d') = (DATE_FORMAT(now(),'%Y%m%d'))", nativeQuery = true)
//	public Object payDate(Date now);
	
	@Query(value="SELECT * from commonuser where DATE_FORMAT(Pay_Date,'%Y%m%d') BETWEEN :startday and :endday ORDER BY pay_date desc", nativeQuery = true)
	public List<CommonUser> findAll(String startday ,String endday);
}
