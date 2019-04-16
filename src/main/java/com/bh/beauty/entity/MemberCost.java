package com.bh.beauty.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name="membercost")
public class MemberCost {

	@Id  
	@GeneratedValue 
	private int id ;
    private int memberId;
    private String name ;
    private String phoneNumber;
    private Timestamp payDate;
    private String  memberType ;
    private int memberNumber;
    private String remarks ;
    private String repsoenPerson; 
    private String leaderPerson ;
    private String assginPerson ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
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
	public Timestamp getPayDate() {
		return payDate;
	}
	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
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
	public String getLeaderPerson() {
		return leaderPerson;
	}
	public void setLeaderPerson(String leaderPerson) {
		this.leaderPerson = leaderPerson;
	}
	public String getAssginPerson() {
		return assginPerson;
	}
	public void setAssginPerson(String assginPerson) {
		this.assginPerson = assginPerson;
	}
}
