package com.cartservice.entity;

import java.util.List;

public class CartCalculation {
	List<Cart> cart;
	long totalprice;
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	public long getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(long totalprice) {
		this.totalprice = totalprice;
	}
	public CartCalculation(List<Cart> cart, long totalprice) {
		super();
		this.cart = cart;
		this.totalprice = totalprice;
	}
	
	

}
