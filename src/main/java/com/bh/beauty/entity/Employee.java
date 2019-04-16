package com.bh.beauty.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * 员工类型
 * @author Administrator
 *
 */
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name="employee")
public class Employee {
	
	@Id  
	@GeneratedValue 
	private int id;
	private int employeeId;
    private String employeeType;
    private String employeeName;
    private String employeePhone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
}
