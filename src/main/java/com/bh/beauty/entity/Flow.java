package com.bh.beauty.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

import java.sql.Timestamp;
/**
  *   流水账单
 * @author Administrator
 *
 */
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name="flowing")
public class Flow {

	@Id  
	@GeneratedValue 
	private int flowingId;
	private int memberId;
	private String costType;
	private Timestamp costDate;
	private String operator;
	private String leader;
	private String assistant;
	public int getFlowingId() {
		return flowingId;
	}
	public void setFlowingId(int flowingId) {
		this.flowingId = flowingId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getCostType() {
		return costType;
	}
	public void setCostType(String costType) {
		this.costType = costType;
	}
	
	public Timestamp getCostDate() {
		return costDate;
	}
	public void setCostDate(Timestamp costDate) {
		this.costDate = costDate;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getAssistant() {
		return assistant;
	}
	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}
	
	
}
