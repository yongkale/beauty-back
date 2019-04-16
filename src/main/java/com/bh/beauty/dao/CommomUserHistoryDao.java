package com.bh.beauty.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bh.beauty.entity.CommomUserHistory;

public interface CommomUserHistoryDao   extends JpaRepository<CommomUserHistory, Long>, JpaSpecificationExecutor<CommomUserHistory>,Serializable {

}
