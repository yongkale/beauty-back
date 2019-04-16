package com.bh.beauty.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bh.beauty.entity.Costtype;

public interface ConstTypeDao extends JpaRepository<Costtype, Long>, JpaSpecificationExecutor<Costtype>,Serializable {

}
