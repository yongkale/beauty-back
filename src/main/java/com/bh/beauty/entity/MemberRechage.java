package com.bh.beauty.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * 会员充值
 * @author Administrator
 *
 */

@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name="memberrecharge")
public class MemberRechage {
	
	@Id  
	@GeneratedValue 
    private int id;
	private int  memberId;
    public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	private String name ;
    private String phoneNumber;
    private int memberMeony;
    private Timestamp payDate;
    private String remarks;
    private String repsoenPerson ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getMemberMeony() {
		return memberMeony;
	}
	public void setMemberMeony(int memberMeony) {
		this.memberMeony = memberMeony;
	}
	public Timestamp getPayDate() {
		return payDate;
	}
	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getRepsoenPerson() {
		return repsoenPerson;
	}
	public void setRepsoenPerson(String repsoenPerson) {
		this.repsoenPerson = repsoenPerson;
	}
}
