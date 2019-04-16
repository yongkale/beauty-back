package com.bh.beauty.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * 消费类型
 * @author Administrator
 *
 */
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name="costtype")
public class Costtype {
	
	@Id  
	@GeneratedValue 
    private int typeID;
	private String typeName;
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	} 
	
	
}
