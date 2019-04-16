package com.bh.beauty.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

import java.sql.Timestamp;
/**
  * 充值
 * @author Administrator
 *
 */

@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name="recharge")
public class Recharge {

	@Id  
	@GeneratedValue 
	private int incomeId;
	private int memberId;
	private int rechargeMoney;
	private int rechargeNumber;
	private Timestamp rechargeDate;
	private String operator;
	public int getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getRechargeMoney() {
		return rechargeMoney;
	}
	public void setRechargeMoney(int rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}
	public int getRechargeNumber() {
		return rechargeNumber;
	}
	public void setRechargeNumber(int rechargeNumber) {
		this.rechargeNumber = rechargeNumber;
	}
	
	public Timestamp getRechargeDate() {
		return rechargeDate;
	}
	public void setRechargeDate(Timestamp rechargeDate) {
		this.rechargeDate = rechargeDate;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	
}
