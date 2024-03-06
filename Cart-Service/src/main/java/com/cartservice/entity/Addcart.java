package com.cartservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

public class Addcart {
	private int aid;
	private int pid;
	private int uid;
    private int quantity;
    //private int size;
 /*   public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}*/
	private long price;
    @Lob
    private byte[] image;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	public Addcart(int aid, int pid, int uid, int quantity, long price, byte[] image) {
		super();
		this.aid = aid;
		this.pid = pid;
		this.uid = uid;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
		//this.size=size;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Addcart() {
		super();
		// TODO Auto-generated constructor stub
	}
    

}

