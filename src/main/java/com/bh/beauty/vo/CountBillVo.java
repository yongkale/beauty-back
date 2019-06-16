package com.bh.beauty.vo;

import java.math.BigDecimal;

public class CountBillVo {
	private String product;
	private BigDecimal hair;
	private BigDecimal nails;
	private BigDecimal beauty;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public BigDecimal getHair() {
		return hair;
	}
	public void setHair(BigDecimal hair) {
		this.hair = hair;
	}
	public BigDecimal getNails() {
		return nails;
	}
	public void setNails(BigDecimal nails) {
		this.nails = nails;
	}
	public BigDecimal getBeauty() {
		return beauty;
	}
	public void setBeauty(BigDecimal beauty) {
		this.beauty = beauty;
	}
}
