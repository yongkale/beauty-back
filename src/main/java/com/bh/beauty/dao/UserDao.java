package com.bh.beauty.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.bh.beauty.entity.User;

public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>,
Serializable {
	
	@Query(value = "select count(*) from userinfo", nativeQuery = true)
	long count();

	public User findByUserName(String userName);
}



