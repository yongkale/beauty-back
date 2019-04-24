package com.bh.beauty.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.bh.beauty.entity.MemberRechage;

public interface MemberRechageDao extends JpaRepository<MemberRechage, Long>, JpaSpecificationExecutor<MemberRechage>,Serializable {

	@Query(value="SELECT sum(member_Meony) FROM memberrecharge where DATE_FORMAT(Pay_Date,'%Y%m%d') BETWEEN :startday and :endday", nativeQuery = true)
	public Object payDate(String startday ,String endday);
	
	@Query(value="SELECT * from memberrecharge where DATE_FORMAT(Pay_Date,'%Y%m%d') BETWEEN :startday and :endday ORDER BY pay_date desc", nativeQuery = true)
	public List<MemberRechage> findAll(String startday ,String endday);

	public List<MemberRechage> findByMemberIdAndMemberType(int memberId, String memberType);
}
