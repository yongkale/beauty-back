package com.bh.beauty.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Timestamp;
/**
   * 会员用户
 * @author Administrator
 *
 */

@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name="memberuserhistoy")
public class MemberUserHistoy {

	@Id  
	@GeneratedValue 
	private int id;
	
	private int idRef;
	
	
	
	public int getIdRef() {
		return idRef;
	}
	public void setIdRef(int idRef) {
		this.idRef = idRef;
	}
	private String repsoenPerson;
	
	private int memberId;
	
	private String name;
	
	private String phoneNumber;
	
	private Timestamp createDate;
	
	private String remarks;
	
	private int memberMeony;
	
	private String weChatNumber;
	
	private String memberType;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRepsoenPerson() {
		return repsoenPerson;
	}
	public void setRepsoenPerson(String repsoenPerson) {
		this.repsoenPerson = repsoenPerson;
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
	
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getMemberMeony() {
		return memberMeony;
	}
	public void setMemberMeony(int memberMeony) {
		this.memberMeony = memberMeony;
	}
	public String getWeChatNumber() {
		return weChatNumber;
	}
	public void setWeChatNumber(String weChatNumber) {
		this.weChatNumber = weChatNumber;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
}
