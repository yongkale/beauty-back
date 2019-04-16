package com.bh.beauty.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bh.beauty.entity.MemberCost;

public interface MemberCostDao extends JpaRepository<MemberCost, Long>, JpaSpecificationExecutor<MemberCost>,Serializable {
	public List<MemberCost> findByMemberIdAndMemberType(int memberId, String memberType);
}
