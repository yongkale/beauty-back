package com.bh.beauty.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name="commomuserhistory")
public class CommomUserHistory {
	@Id  
	@GeneratedValue 
	private int id;
	private int commonId;
	private int remainMoney;
	private Timestamp updateDate;

	public int getCommonId() {
		return commonId;
	}
	public void setCommonId(int commonId) {
		this.commonId = commonId;
	}
	public int getRemainMoney() {
		return remainMoney;
	}
	public void setRemainMoney(int remainMoney) {
		this.remainMoney = remainMoney;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
}
