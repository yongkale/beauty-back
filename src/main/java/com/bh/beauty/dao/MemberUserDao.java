package com.bh.beauty.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bh.beauty.entity.MemberUser;


public interface MemberUserDao extends JpaRepository<MemberUser, Long>, JpaSpecificationExecutor<MemberUser>,Serializable {
	
	/*
	 * @Transactional
	 * 
	 * @Modifying
	 * 
	 * @Query(value =
	 * "INSERT INTO memberuser VALUES ('张三', '178092100000', '2019-04-18 19:24:37', '1000', '正常充值', null, '1', '美发', '10')"
	 * , nativeQuery = true) int insert();
	 */
	@Query(value="select * from memberuser where Member_ID like :searchKey", nativeQuery = true)
	public List<MemberUser> search(String searchKey);
	
	@Query(value="select * from memberuser order by create_date desc", nativeQuery = true)
	public List<MemberUser> findAll ();
	
	@Query(name = "select * from memberuser m where m.phone_number=:phoneNumber")
	public MemberUser findByPhoneNumber(String phoneNumber);
	

	public MemberUser findByMemberId(int memberId);
	
	public MemberUser findById(int id);
	

//	@Query(value = "")
	public MemberUser findByMemberIdAndMemberType(int memberId, String memberType);
}
