package com.va.deliveryApplication.jk.model;


public class DeliveryDetails {
	private String jkPaymentMethod;
	private long jkCardNumber;
	private String jkPromoCode;
	private String jkAddress;
	public DeliveryDetails()
	{}
	public DeliveryDetails(String jkPaymentMethod, long jkCardNumber, String jkPromoCode, String jkAddress) {
		super();
		this.jkPaymentMethod = jkPaymentMethod;
		this.jkCardNumber = jkCardNumber;
		this.jkPromoCode = jkPromoCode;
		this.jkAddress = jkAddress;
	}
	public String getJkPaymentMethod() {
		return jkPaymentMethod;
	}
	public void setJkPaymentMethod(String jkPaymentMethod) {
		this.jkPaymentMethod = jkPaymentMethod;
	}
	public long getJkCardNumber() {
		return jkCardNumber;
	}
	public void setJkCardNumber(long jkCardNumber) {
		this.jkCardNumber = jkCardNumber;
	}
	public String getJkPromoCode() {
		return jkPromoCode;
	}
	public void setJkPromoCode(String jkPromoCode) {
		this.jkPromoCode = jkPromoCode;
	}
	public String getJkAddress() {
		return jkAddress;
	}
	public void setJkAddress(String jkAddress) {
		this.jkAddress = jkAddress;
	}
	

}