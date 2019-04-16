package com.bh.beauty.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bh.beauty.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee>,Serializable {

}
