package com.bh.beauty.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.bh.beauty.entity.CommonUser;

public interface CommmonUserDao  extends JpaRepository<CommonUser, Long>, JpaSpecificationExecutor<CommonUser>,Serializable {

	@Query(value="SELECT sum(pay_money) FROM commonuser where DATE_FORMAT(Pay_Date,'%Y%m%d') BETWEEN :startday and :endday ORDER BY pay_date desc", nativeQuery = true)
	public Object payDate(String startday ,String endday);

//	@Query(value="SELECT sum(pay_money) FROM commonuser where DATE_FORMAT(Pay_Date,'%Y%m%d') = (DATE_FORMAT(now(),'%Y%m%d'))", nativeQuery = true)
//	public Object payDate(Date now);
	
	@Query(value="SELECT * from commonuser where DATE_FORMAT(Pay_Date,'%Y%m%d') BETWEEN :startday and :endday ORDER BY pay_date desc", nativeQuery = true)
	public List<CommonUser> findAll(String startday ,String endday);

	@Query(value = "select * from commonuser where (leader_Person=:peploeName or assgin_person=:peploeName) and DATE_FORMAT(Pay_Date,'%Y%m%d') BETWEEN :startday and :endday ORDER BY pay_date desc", nativeQuery = true)
	public List<CommonUser> findByPeploeName(String peploeName,  String startday ,String endday);

	@Query(value = "select * from commonuser where cost_type=:type and DATE_FORMAT(Pay_Date,'%Y%m%d') BETWEEN :startday and :endday ORDER BY pay_date desc", nativeQuery = true)
	public List<CommonUser> findByType(String type, String startday, String endday);

	@Query(value = "select cost_type,sum(pay_money) as count from commonuser where DATE_FORMAT(Pay_Date,'%Y%m%d') BETWEEN :startday and :endday  group by cost_type", nativeQuery = true)
	public List<Map<String, Long>>  findByType(String startday, String endday);

	@Query(value = "select cost_type as type,sum(pay_money) as count from commonuser where (leader_Person=:peploeName or assgin_person=:peploeName) and DATE_FORMAT(Pay_Date,'%Y%m%d') BETWEEN :startday and :endday group by cost_type", nativeQuery = true)
	public List<Map<String, BigDecimal>> findCountPeopleByType(String peploeName, String startday ,String endday);

	@Query(value = "select cost_type,sum(pay_money) as count from commonuser where DATE_FORMAT(Pay_Date,'%Y%m%d') BETWEEN :startday and :endday  group by cost_type", nativeQuery = true)
	public List<Map<String, Long>> findMoneyByType(String startday ,String endday);
}
