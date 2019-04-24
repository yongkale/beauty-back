package com.bh.beauty.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.bh.beauty.entity.MemberCost;

public interface MemberCostDao extends JpaRepository<MemberCost, Long>, JpaSpecificationExecutor<MemberCost>,Serializable {

	public List<MemberCost> findByMemberIdAndMemberType(int memberId, String memberType);

	@Query(value = "select * from membercost where member_Type=:memberType and DATE_FORMAT(Pay_Date,'%Y%m%d') BETWEEN :startday and :endday ORDER BY pay_date desc", nativeQuery = true)
	public List<MemberCost> findByMemberType(String memberType,String startday ,String endday);

	@Query(value = "select * from membercost where (leader_Person=:peploeName or assgin_person=:peploeName) and DATE_FORMAT(Pay_Date,'%Y%m%d') BETWEEN :startday and :endday ORDER BY pay_date desc", nativeQuery = true)
	public List<MemberCost> findByPople(String peploeName, String startday ,String endday);
}
