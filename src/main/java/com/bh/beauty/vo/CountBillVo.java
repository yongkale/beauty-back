package com.bh.beauty.vo;

import java.math.BigInteger;

public class CountBillVo {
	private String product;
	private BigInteger hair;
	private BigInteger nails;
	private BigInteger beauty;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public BigInteger getHair() {
		return hair;
	}
	public void setHair(BigInteger hair) {
		this.hair = hair;
	}
	public BigInteger getNails() {
		return nails;
	}
	public void setNails(BigInteger nails) {
		this.nails = nails;
	}
	public BigInteger getBeauty() {
		return beauty;
	}
	public void setBeauty(BigInteger beauty) {
		this.beauty = beauty;
	}
}
