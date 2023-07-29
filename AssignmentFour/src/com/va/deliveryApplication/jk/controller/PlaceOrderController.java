package com.va.deliveryApplication.jk.controller;

import com.va.deliveryApplication.jk.model.*;
import com.va.deliveryApplication.jk.view.*;

public class PlaceOrderController {
	private PlaceOrder model;
	public PlaceOrderController(PlaceOrder model, PlaceOrderView view) {
		super();
		this.model = model;
	}

	// getters and setters for the itemName
	public String getJkItemName() {
		return model.getJkItemName();
	}

	public void setJkItemName(String jkItemName) {
		model.setJkItemName(jkItemName);
	}

	// getters and setters for the jkOrderId
	public String getJkOrderId() {
		return model.getJkOrderId();
	}

	public void setJkOrderId(String jkOrderId) {
		model.setJkOrderId(jkOrderId);
	}

	// getters and setters for the jkQuantity
	public int getJkQuantity() {
		return model.getJkQuantity();
	}

	public void setJkQuantity(int jkQuantity) {
		model.setJkQuantity(jkQuantity);
	}

	// getters and setters for the jkPrice
	public double getJkPrice() {
		return model.getJkPrice();
	}

	public void setJkPrice(double jkPrice) {
		model.setJkPrice(jkPrice);
	}
	
	


}

