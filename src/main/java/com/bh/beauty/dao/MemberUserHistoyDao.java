package com.bh.beauty.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bh.beauty.entity.MemberUser;
import com.bh.beauty.entity.MemberUserHistoy;

public interface MemberUserHistoyDao extends JpaRepository<MemberUserHistoy, Long>, JpaSpecificationExecutor<MemberUserHistoy>,Serializable {

	List<MemberUserHistoy> findByIdRef(int idRef);

}
