package com.bh.beauty.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import java.sql.Timestamp;
/**
   * 普通用户
 * @author Administrator
 *
 */
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name="commonuser")
public class CommonUser {

	@Id  
	@GeneratedValue 
	private int commonId;
	private String costType;
	private Timestamp payDate;
	private int payMoney;
	private String repsoenPerson;
	private String leaderPerson;
	private String assginPerson;
	
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
	public int getCommonId() {
		return commonId;
	}
	public void setCommonId(int commonId) {
		this.commonId = commonId;
	}
	public String getCostType() {
		return costType;
	}
	public void setCostType(String costType) {
		this.costType = costType;
	}
	
	public Timestamp getPayDate() {
		return payDate;
	}
	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}
	public int getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}
	
	
}
