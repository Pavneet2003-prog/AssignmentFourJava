package com.va.deliveryApplication.jk.model;

public class PlaceOrder {
	private String jkItemName;
	private String jkOrderId;
	private int jkQuantity;
	private double jkPrice;
	public PlaceOrder(String jkItemName, String jkOrderId, int jkQuantity, double jkPrice) {
		super();
		this.jkItemName = jkItemName;
		this.jkOrderId = jkOrderId;
		this.jkQuantity = jkQuantity;
		this.jkPrice = jkPrice;
	}
	public String getJkItemName() {
		return jkItemName;
	}
	public void setJkItemName(String jkItemName) {
		this.jkItemName = jkItemName;
	}
	public String getJkOrderId() {
		return jkOrderId;
	}
	public void setJkOrderId(String jkOrderId) {
		this.jkOrderId = jkOrderId;
	}
	public int getJkQuantity() {
		return jkQuantity;
	}
	public void setJkQuantity(int jkQuantity) {
		this.jkQuantity = jkQuantity;
	}
	public double getJkPrice() {
		return jkPrice;
	}
	public void setJkPrice(double jkPrice) {
		this.jkPrice = jkPrice;
	}
	
	
}
