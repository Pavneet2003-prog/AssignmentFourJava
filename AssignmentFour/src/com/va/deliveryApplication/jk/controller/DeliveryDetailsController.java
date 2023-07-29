package com.va.deliveryApplication.jk.controller;

import com.va.deliveryApplication.jk.model.*;
import com.va.deliveryApplication.jk.view.*;

public class DeliveryDetailsController {
	private DeliveryDetails model;
	public DeliveryDetailsController(DeliveryDetails model, DeliveryDetailsView view) {
		super();
		this.model = model;
	}

	// getters and setters for the Payment Method
	public String getJkPaymentMethod() {
		return model.getJkPaymentMethod();
	}

	public void setJkPaymentMethod(String jkPaymentMethod) {
		model.setJkPaymentMethod(jkPaymentMethod);
	}

	// getters and setters for the card Number
	public long getJkCardNumber() {
		return model.getJkCardNumber();
	}

	public void setJkCardNumber(long jkCardNumber) {
		model.setJkCardNumber(jkCardNumber);
	}

	// getters and setters for the Promo Code
	public String getJkPromoCode() {
		return model.getJkPromoCode();
	}

	public void setJkPhoneNumber(String jkPromoCode) {
		model.setJkPromoCode(jkPromoCode);
	}

	// getters and setters for the Address
	public String getJkAddress() {
		return model.getJkAddress();
	}

	public void setJkAddress(String jkAddress) {
		model.setJkAddress(jkAddress);
	}
	
	


}


