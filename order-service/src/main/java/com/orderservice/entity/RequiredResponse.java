package com.orderservice.entity;

public class RequiredResponse {
	private Order order;
	private Item item;
	
	public RequiredResponse() {
		super();
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	

}
