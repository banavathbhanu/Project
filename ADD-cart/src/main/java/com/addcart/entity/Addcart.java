package com.addcart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Addcart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aid;
	private int pid;
	private int uid;
    private int quantity;
    private long price;
    private int orprice;
    public int getOrprice() {
		return orprice;
	}
	public void setOrprice(int orprice) {
		this.orprice = orprice;
	}
	@Lob
    private byte[] image;
    public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
/*	private int size;
	public int getAid() {
		return aid;
	}*/
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
	public Addcart(int aid, int pid, int uid, int quantity, long price,int orprice) {
		super();
		this.aid = aid;
		this.pid = pid;
		this.uid = uid;
		this.quantity = quantity;
		this.price = price;
	//	this.size=size;
		this.orprice=orprice;
	}
	/*public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}*/
	public Addcart() {
		super();
		// TODO Auto-generated constructor stub
	}
    

}
