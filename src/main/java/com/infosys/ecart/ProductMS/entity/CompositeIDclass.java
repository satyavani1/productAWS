package com.infosys.ecart.ProductMS.entity;

import java.io.Serializable;

public class CompositeIDclass implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String buyerId;
	private Integer prodId;
	
	public CompositeIDclass() {
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}	
}
